package com.udpt.requestService.Service;

import com.udpt.requestService.Entity.GeneralInfo;
import com.udpt.requestService.Entity.Request.GeneralInfoRequest;
import com.udpt.requestService.HandleException.NotFoundException;
import com.udpt.requestService.Repository.GeneralInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GeneralInfoService {
    @Autowired
    private GeneralInfoRepository generalInfoRepository;

    private int generalInfoId;

    private GeneralInfoRequest generalInfoRequest;

    private GeneralInfo generalInfo;

    public void setGeneralInfoId(int generalInfoId) {
        this.generalInfoId = generalInfoId;
    }

    public void setGeneralInfoRequest(GeneralInfoRequest generalInfoRequest) {
        this.generalInfoRequest = generalInfoRequest;
    }

    public void setGeneralInfo(GeneralInfo generalInfo) {
        this.generalInfo = generalInfo;
    }

    public List<GeneralInfo> getAllGeneralInfo() {
        return generalInfoRepository.findAll();
    }

    public GeneralInfo getGeneralInfoByGeneralInfoId() {
        Optional<GeneralInfo> optionalGeneralInfo = generalInfoRepository.findById(generalInfoId);
        if (!optionalGeneralInfo.isPresent()) {
            throw new NotFoundException("general info has id "+ generalInfoId);
        }
        return optionalGeneralInfo.get();
    }

    public String addNewGeneralInfo() {
        GeneralInfo generalInfo = new GeneralInfo();
        generalInfo.setDate(generalInfoRequest.getDate());
        generalInfo.setDescribe(generalInfoRequest.getDescribe());
        generalInfo.setAuthor(generalInfoRequest.getAuthor());
        generalInfo.setTitle(generalInfoRequest.getTitle());

        generalInfoRepository.save(generalInfo);
        return "General info was added successful";
    }

    public String editGeneralInfo() {
        Optional<GeneralInfo> optionalGeneralInfo = generalInfoRepository.findById(generalInfo.getGeneralInfoId());
        if (!optionalGeneralInfo.isPresent()) {
            throw new NotFoundException("General info has id " + generalInfoId);
        }

        GeneralInfo generalInfoDB = optionalGeneralInfo.get();
        generalInfoDB.setTitle(generalInfo.getTitle());
        generalInfoDB.setDate(generalInfo.getDate());
        generalInfoDB.setAuthor(generalInfo.getAuthor());
        generalInfoDB.setDescribe(generalInfo.getDescribe());
        generalInfoRepository.save(generalInfoDB);
        return "General info was edited";
    }

    public String deleteGeneralInfo() {
        Optional<GeneralInfo> optionalGeneralInfo = generalInfoRepository.findById(generalInfoId);

        if (!optionalGeneralInfo.isPresent()) {
            throw new NotFoundException("General info has id " + generalInfoId);
        }

        generalInfoRepository.delete(optionalGeneralInfo.get());
        return "General has id " + generalInfoId + " was deleted";
    }
}
