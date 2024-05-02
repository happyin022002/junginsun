package com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.vo;

import java.util.List;

import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.usa.vo.ExpRuleSetupVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.usa.vo.ImpRuleSetupVO;

/**
 * Container Value Ojbect<br>
 * - PDTO(Data Transfer Object including Parameters)<br>
 * - 관련 Event에서 작성, 서버실행요청시 PDTO의 역할을 수행하는 Value Object<br>
 *
 * @author 이수빈
 * @since J2EE 1.5
 */

public class SetupListModVO {

    private List<ExpRuleSetupVO> expRuleSetupVOS = null;
    private List<ImpRuleSetupVO> impRuleSetupVOS = null;

    public List<ExpRuleSetupVO> getExpRuleSetupVOS() {
        return expRuleSetupVOS;
    }

    public void setExpRuleSetupVOS(List<ExpRuleSetupVO> expRuleSetupVOS) {
        this.expRuleSetupVOS = expRuleSetupVOS;
    }

    public List<ImpRuleSetupVO> getImpRuleSetupVOS() {
        return impRuleSetupVOS;
    }

    public void setImpRuleSetupVOS(List<ImpRuleSetupVO> impRuleSetupVOS) {
        this.impRuleSetupVOS = impRuleSetupVOS;
    }
}
