/*=========================================================
*@FileName       : EsmBkg0128Event.java
*@FileTitle      : Cargo Release (D/O)
*Open Issues     :
*Change history  :
*@LastModifyDate : 2009.09.16
*@LastModifier   : 
*@LastVersion    : 1.0
* 2009.09.16 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.event;

import com.clt.apps.opus.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.BlIssVO;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.DoAsignVO;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.DoBlInfoVO;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.DoCancelVO;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.DoCntrVO;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.DoHoldVO;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.DoRlseStsVO;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.DoRlseVO;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.DoSaveVO;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.EuDoCntrRlseStsVO;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.EuDoRlseStsVO;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.EuDoRlseVO;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.GenDoBlInfoVO;
import com.clt.framework.support.layer.event.EventSupport;
import com.clt.syscommon.common.table.BkgDoRefVO;
import com.clt.syscommon.common.table.BkgDoVO;

/**
 * esm_bkg_0128 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - ESM_BKG_0128HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author
 * @see ESM_BKG_0128HTMLAction 참조
 * @since J2EE 1.4
 */

public class EsmBkg0128Event extends EventSupport {

    /**
     *
     */
    private static final long serialVersionUID = 8656847190059914500L;

    /**
     * D/O Release Reference
     */
    private BkgDoRefVO[] refInfos = null;

    /**
     * Original B/L 회수 여부와 발행 통수 및  Detail정보
     */
    private BlIssVO[] blIssVOs = null;

    /**
     * D/O Release 기본 정보
     */
    private BkgDoVO[] blInfos = null;
    private GenDoBlInfoVO[] genBlInfos = null;

    /**
     * DO Save 저장 VO
     */
    private DoSaveVO doSave = null;
    private DoAsignVO[] doAsign = null;
    private DoRlseVO[] doRlse = null;
    private DoHoldVO[] doHold = null;
    /**
     * B/L별 D/O의  정보
     */
    private DoCntrVO[] doCntrs = null;
    private DoCancelVO doCancel = null;
    private DoBlInfoVO[] doBlInfo = null;
    /**
     * B/L별 D/O의 STATUS
     */
    private DoRlseStsVO[] doRlseSts = null;
    private EuDoCntrRlseStsVO[] doCntrRlseSts = null;
    /**
     * B/L별 D/O의 STATUS
     */
    private EuDoRlseStsVO[] euDoRlseSts = null;
    /**
     * B/L별 D/O의 Release 정보
     */
    private DoRlseVO genDoRlse = null;

    /**
     * 선적예약 요청 번호
     */
    private String bkgNo = "";

    /**
     * 선화증권 번호
     */
    private String blNo = "";

    /**
     * Demurrage 타입
     */
    private String demurType = "";

    /**
     * Expect Delivery Date
     */
    private String expDelDt  = "";

    /**
     * O/BL 회수  여부 원래 값
     */
    private String oriOblRdemFlg = "";

    /**
     * O/BL 회수  여부 입력 요건에 따라서 변경 된 값
     */
    private String aftOblRdemFlg = "";

    /**
     * D/O 관련업무에서 발생하는 주요 EVENT
     */
    private String doCngEvntCd = "";

    /**
     * D/O EVENT에서 변경되기 전의 값
     */
    private String preCtnt   = "";

    /**
     * D/O EVENT에서 변경된 값
     */
    private String crntCtnt  = "";

    /**
     * partial 여부
     */
    private String cntrPrtFlg = "";

    /**
     * D/O의 진행 상태 코드
     */
    private String rlseStsCd   = "";

    /**
     * D/O의 최종 진행 상태 코드
     */
    private String lastRlseStsCd = "";

    /**
     * DOR 버튼 클릭 시 설정 값
     */
    private String svcCd = "";


    /**
     * O/BL 변경 이벤트 발생
     */
    private String oblCngFlg = "";

    private String cstmsRefNm = "";
    private String cstmsRefCtnt = "";
    private String cstmsAsgnNm = "";
    private String cstmsAsgnCtnt = "";
    private String interRmk = "";
    private String doSplitFlg = "";
    private String evntFlag = "";
    private String resetFlg = "";
    private String releaseRemark = "";  
    
    private String doNo = "";
    private String splitFlg = "";
    /**
     * @param bkgNo the bkgNo to set
     */
    public void setBkgNo(String bkgNo) {
        this.bkgNo = bkgNo;
    }

    /**
     * @return the bkgNo
     */
    public String getBkgNo() {
        return bkgNo;
    }

    /**
     * @param blNo the blNo to set
     */
    public void setBlNo(String blNo) {
        this.blNo = blNo;
    }

    /**
     * @param bkgNo the bkgNo to set
     */
    public void setReleaseRemark(String releaseRemark) {
        this.releaseRemark = releaseRemark;
    }
    
    /**
     * @return the blNo
     */
    public String getReleaseRemark() {
        return releaseRemark;
    }
    
    /**
     * @return the blNo
     */
    public String getBlNo() {
        return blNo;
    }

    /**
     * @return the demurType
     */
    public String getDemurType() {
        return demurType;
    }

    /**
     * @param demurType the demurType to set
     */
    public void setDemurType(String demurType) {
        this.demurType = demurType;
    }

    /**
     * @return the expDelDt
     */
    public String getExpDelDt() {
        return expDelDt;
    }

    /**
     * @param expDeldt the expDelDt to set
     */
    public void setExpDelDt(String expDelDt) {
        this.expDelDt = expDelDt;
    }

    /**
     * @return the oriOblRdemFlg
     */
    public String getOriOblRdemFlg() {
        return oriOblRdemFlg;
    }

    /**
     * @param oriOblRdemFlg the oriOblRdemFlg to set
     */
    public void setOriOblRdemFlg(String oriOblRdemFlg) {
        this.oriOblRdemFlg = oriOblRdemFlg;
    }

    /**
     * @return the aftOblRdemFlg
     */
    public String getAftOblRdemFlg() {
        return aftOblRdemFlg;
    }

    /**
     * @param aftOblRdemFlg the aftOblRdemFlg to set
     */
    public void setAftOblRdemFlg(String aftOblRdemFlg) {
        this.aftOblRdemFlg = aftOblRdemFlg;
    }

    /**
     * @return the blIssVOs
     */
//    public BlIssVO[] getBlIssVOs() {
//        return blIssVOs;
//    }

	//2015.04.10 Secure Coding 적용[CWE-496]
    public BlIssVO[] getBlIssVOs() {
    	BlIssVO[] tmpVOs = null;
		if (this.blIssVOs != null) {
			tmpVOs = new BlIssVO[blIssVOs.length];
			System.arraycopy(blIssVOs, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;		
	}	    
    
    /**
     * @param blIssVOs the blIssVOs to set
     */
//    public void setBlIssVOs(BlIssVO[] blIssVOs) {
//        this.blIssVOs = blIssVOs;
//    }

	//2015.04.10 Secure Coding 적용[CWE-496]
    public void setBlIssVOs(BlIssVO[] blIssVOs) {
		if (blIssVOs != null) {
			BlIssVO[] tmpVOs = new BlIssVO[blIssVOs.length];
			System.arraycopy(blIssVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.blIssVOs = tmpVOs;
		}		
	}     
    
    /**
     * @return the refInfos
     */
//    public BkgDoRefVO[] getRefInfos() {
//        return refInfos;
//    }

	//2015.04.10 Secure Coding 적용[CWE-496]
    public BkgDoRefVO[] getRefInfos() {
    	BkgDoRefVO[] tmpVOs = null;
		if (this.refInfos != null) {
			tmpVOs = new BkgDoRefVO[refInfos.length];
			System.arraycopy(refInfos, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;		
	}
    
    /**
     * @param refInfos the refInfos to set
     */
//    public void setRefInfos(BkgDoRefVO[] refInfos) {
//        this.refInfos = refInfos;
//    }

	//2015.04.10 Secure Coding 적용[CWE-496]
    public void setRefInfos(BkgDoRefVO[] refInfos) {
		if (refInfos != null) {
			BkgDoRefVO[] tmpVOs = new BkgDoRefVO[refInfos.length];
			System.arraycopy(refInfos, 0, tmpVOs, 0, tmpVOs.length);
			this.refInfos = tmpVOs;
		}		
	}      
    
    /**
     * @return the blInfos
     */
//    public BkgDoVO[] getBlInfos() {
//        return blInfos;
//    }

	//2015.04.10 Secure Coding 적용[CWE-496]
    public BkgDoVO[] getBlInfos() {
    	BkgDoVO[] tmpVOs = null;
		if (this.blInfos != null) {
			tmpVOs = new BkgDoVO[blInfos.length];
			System.arraycopy(blInfos, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;		
	}    
    
    /**
     * @param blInfos the blInfos to set
     */
//    public void setBlInfos(BkgDoVO[] blInfos) {
//        this.blInfos = blInfos;
//    }
    
	//2015.04.10 Secure Coding 적용[CWE-496]
    public void setBlInfos(BkgDoVO[] blInfos) {
		if (blInfos != null) {
			BkgDoVO[] tmpVOs = new BkgDoVO[blInfos.length];
			System.arraycopy(blInfos, 0, tmpVOs, 0, tmpVOs.length);
			this.blInfos = tmpVOs;
		}		
	}     

    /**
     * @return the doCngEvntCd
     */
    public String getDoCngEvntCd() {
        return doCngEvntCd;
    }

    /**
     * @param doCngEvntCd the doCngEvntCd to set
     */
    public void setDoCngEvntCd(String doCngEvntCd) {
        this.doCngEvntCd = doCngEvntCd;
    }

    /**
     * @return the preCtnt
     */
    public String getPreCtnt() {
        return preCtnt;
    }

    /**
     * @param preCtnt the preCtnt to set
     */
    public void setPreCtnt(String preCtnt) {
        this.preCtnt = preCtnt;
    }

    /**
     * @return the crntCtnt
     */
    public String getCrntCtnt() {
        return crntCtnt;
    }

    /**
     * @param crntCtnt the crntCtnt to set
     */
    public void setCrntCtnt(String crntCtnt) {
        this.crntCtnt = crntCtnt;
    }

    public String getCntrPrtFlg() {
        return cntrPrtFlg;
    }

    public void setCntrPrtFlg(String cntrPrtFlg) {
        this.cntrPrtFlg = cntrPrtFlg;
    }

    public String getRlseStsCd() {
        return rlseStsCd;
    }

    public void setRlseStsCd(String rlseStsCd) {
        this.rlseStsCd = rlseStsCd;
    }

    public String getLastRlseStsCd() {
        return lastRlseStsCd;
    }

    public void setLastRlseStsCd(String lastRlseStsCd) {
        this.lastRlseStsCd = lastRlseStsCd;
    }

    public String getSvcCd() {
        return svcCd;
    }

    public void setSvcCd(String svcCd) {
        this.svcCd = svcCd;
    }


//    public DoCntrVO[] getDoCntrs() {
//        return doCntrs;
//    }
    
	//2015.04.10 Secure Coding 적용[CWE-496]
    public DoCntrVO[] getDoCntrs() {
    	DoCntrVO[] tmpVOs = null;
		if (this.doCntrs != null) {
			tmpVOs = new DoCntrVO[doCntrs.length];
			System.arraycopy(doCntrs, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;		
	}     

//    public void setDoCntrs(DoCntrVO[] doCntrs) {
//        this.doCntrs = doCntrs;
//    }

	//2015.04.10 Secure Coding 적용[CWE-496]
    public void setDoCntrs(DoCntrVO[] doCntrs) {
		if (doCntrs != null) {
			DoCntrVO[] tmpVOs = new DoCntrVO[doCntrs.length];
			System.arraycopy(doCntrs, 0, tmpVOs, 0, tmpVOs.length);
			this.doCntrs = tmpVOs;
		}		
	} 
    
    public String getOblCngFlg() {
        return oblCngFlg;
    }

    public void setOblCngFlg(String oblCngFlg) {
        this.oblCngFlg = oblCngFlg;
    }

    public String getCstmsRefNm() {
        return cstmsRefNm;
    }

    public void setCstmsRefNm(String cstmsRefNm) {
        this.cstmsRefNm = cstmsRefNm;
    }

    public String getCstmsRefCtnt() {
        return cstmsRefCtnt;
    }

    public void setCstmsRefCtnt(String cstmsRefCtnt) {
        this.cstmsRefCtnt = cstmsRefCtnt;
    }

    public String getCstmsAsgnNm() {
        return cstmsAsgnNm;
    }

    public void setCstmsAsgnNm(String cstmsAsgnNm) {
        this.cstmsAsgnNm = cstmsAsgnNm;
    }

    public String getCstmsAsgnCtnt() {
        return cstmsAsgnCtnt;
    }

    public void setCstmsAsgnCtnt(String cstmsAsgnCtnt) {
        this.cstmsAsgnCtnt = cstmsAsgnCtnt;
    }

    public String getInterRmk() {
        return interRmk;
    }

    public void setInterRmk(String interRmk) {
        this.interRmk = interRmk;
    }

    public String getDoSplitFlg() {
        return doSplitFlg;
    }

    public void setDoSplitFlg(String doSplitFlg) {
        this.doSplitFlg = doSplitFlg;
    }

    public DoCancelVO getDoCancel() {
        return doCancel;
    }

    public void setDoCancel(DoCancelVO doCancel) {
        this.doCancel = doCancel;
    }

//    public DoBlInfoVO[] getDoBlInfo() {
//        return doBlInfo;
//    }

	//2015.04.10 Secure Coding 적용[CWE-496]
    public DoBlInfoVO[] getDoBlInfo() {
    	DoBlInfoVO[] tmpVOs = null;
		if (this.doBlInfo != null) {
			tmpVOs = new DoBlInfoVO[doBlInfo.length];
			System.arraycopy(doBlInfo, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;		
	} 
    
//    public void setDoBlInfo(DoBlInfoVO[] doBlInfo) {
//        this.doBlInfo = doBlInfo;
//    }

	//2015.04.10 Secure Coding 적용[CWE-496]
    public void setDoBlInfo(DoBlInfoVO[] doBlInfo) {
		if (doBlInfo != null) {
			DoBlInfoVO[] tmpVOs = new DoBlInfoVO[doBlInfo.length];
			System.arraycopy(doBlInfo, 0, tmpVOs, 0, tmpVOs.length);
			this.doBlInfo = tmpVOs;
		}		
	}    
    
    public String getEvntFlag() {
        return evntFlag;
    }

    public void setEvntFlag(String evntFlag) {
        this.evntFlag = evntFlag;
    }

    public DoSaveVO getDoSave() {
        return doSave;
    }

    public void setDoSave(DoSaveVO doSave) {
        this.doSave = doSave;
    }

//    public DoAsignVO[] getDoAsign() {
//        return doAsign;
//    }
    
	//2015.04.10 Secure Coding 적용[CWE-496]
    public DoAsignVO[] getDoAsign() {
    	DoAsignVO[] tmpVOs = null;
		if (this.doAsign != null) {
			tmpVOs = new DoAsignVO[doAsign.length];
			System.arraycopy(doAsign, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;		
	}     

//    public void setDoAsign(DoAsignVO[] doAsign) {
//        this.doAsign = doAsign;
//    }

	//2015.04.10 Secure Coding 적용[CWE-496]
    public void setDoAsign(DoAsignVO[] doAsign) {
		if (doAsign != null) {
			DoAsignVO[] tmpVOs = new DoAsignVO[doAsign.length];
			System.arraycopy(doAsign, 0, tmpVOs, 0, tmpVOs.length);
			this.doAsign = tmpVOs;
		}		
	}    
    
//    public DoRlseVO[] getDoRlse() {
//        return doRlse;
//    }
    
	//2015.04.10 Secure Coding 적용[CWE-496]
    public DoRlseVO[] getDoRlse() {
    	DoRlseVO[] tmpVOs = null;
		if (this.doRlse != null) {
			tmpVOs = new DoRlseVO[doRlse.length];
			System.arraycopy(doRlse, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;		
	}       

//    public void setDoRlse(DoRlseVO[] doRlse) {
//        this.doRlse = doRlse;
//    }

	//2015.04.10 Secure Coding 적용[CWE-496]
    public void setDoRlse(DoRlseVO[] doRlse) {
		if (doRlse != null) {
			DoRlseVO[] tmpVOs = new DoRlseVO[doRlse.length];
			System.arraycopy(doRlse, 0, tmpVOs, 0, tmpVOs.length);
			this.doRlse = tmpVOs;
		}		
	}    
    
//    public DoHoldVO[] getDoHold() {
//        return doHold;
//    }
    
	//2015.04.10 Secure Coding 적용[CWE-496]
    public DoHoldVO[] getDoHold() {
    	DoHoldVO[] tmpVOs = null;
		if (this.doHold != null) {
			tmpVOs = new DoHoldVO[doHold.length];
			System.arraycopy(doHold, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;		
	}      

//    public void setDoHold(DoHoldVO[] doHold) {
//        this.doHold = doHold;
//    }
    
	//2015.04.10 Secure Coding 적용[CWE-496]
    public void setDoHold(DoHoldVO[] doHold) {
		if (doHold != null) {
			DoHoldVO[] tmpVOs = new DoHoldVO[doHold.length];
			System.arraycopy(doHold, 0, tmpVOs, 0, tmpVOs.length);
			this.doHold = tmpVOs;
		}		
	}    

//    public DoRlseStsVO[] getDoRlseSts() {
//        return doRlseSts;
//    }
    
	//2015.04.10 Secure Coding 적용[CWE-496]
    public DoRlseStsVO[] getDoRlseSts() {
    	DoRlseStsVO[] tmpVOs = null;
		if (this.doRlseSts != null) {
			tmpVOs = new DoRlseStsVO[doRlseSts.length];
			System.arraycopy(doRlseSts, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;		
	}       

//    public void setDoRlseSts(DoRlseStsVO[] doRlseSts) {
//        this.doRlseSts = doRlseSts;
//    }

	//2015.04.10 Secure Coding 적용[CWE-496]
    public void setDoRlseSts(DoRlseStsVO[] doRlseSts) {
		if (doRlseSts != null) {
			DoRlseStsVO[] tmpVOs = new DoRlseStsVO[doRlseSts.length];
			System.arraycopy(doRlseSts, 0, tmpVOs, 0, tmpVOs.length);
			this.doRlseSts = tmpVOs;
		}		
	}
    
    public String getResetFlg() {
        return resetFlg;
    }

    public void setResetFlg(String resetFlg) {
        this.resetFlg = resetFlg;
    }
    
//	public GenDoBlInfoVO[] getGenBlInfos() {
//		return genBlInfos;
//	}
	
	//2015.04.10 Secure Coding 적용[CWE-496]
	public GenDoBlInfoVO[] getGenBlInfos() {
		GenDoBlInfoVO[] tmpVOs = null;
		if (this.genBlInfos != null) {
			tmpVOs = new GenDoBlInfoVO[genBlInfos.length];
			System.arraycopy(genBlInfos, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;		
	}   	

//	public void setGenBlInfos(GenDoBlInfoVO[] genBlInfos) {
//		this.genBlInfos = genBlInfos;
//	}

	//2015.04.10 Secure Coding 적용[CWE-496]
	public void setGenBlInfos(GenDoBlInfoVO[] genBlInfos) {
		if (genBlInfos != null) {
			GenDoBlInfoVO[] tmpVOs = new GenDoBlInfoVO[genBlInfos.length];
			System.arraycopy(genBlInfos, 0, tmpVOs, 0, tmpVOs.length);
			this.genBlInfos = tmpVOs;
		}		
	}
	
//    public EuDoCntrRlseStsVO[] getdoCntrRlseSts() {
//        return doCntrRlseSts;
//    }
    
	//2015.04.10 Secure Coding 적용[CWE-496]
    public EuDoCntrRlseStsVO[] getdoCntrRlseSts() {
    	EuDoCntrRlseStsVO[] tmpVOs = null;
		if (this.doCntrRlseSts != null) {
			tmpVOs = new EuDoCntrRlseStsVO[doCntrRlseSts.length];
			System.arraycopy(doCntrRlseSts, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;		
	}     

//    public void setdoCntrRlseSts(EuDoCntrRlseStsVO[] doCntrRlseSts) {
//        this.doCntrRlseSts = doCntrRlseSts;
//    }
    
	//2015.04.10 Secure Coding 적용[CWE-496]
    public void setdoCntrRlseSts(EuDoCntrRlseStsVO[] doCntrRlseSts) {
		if (doCntrRlseSts != null) {
			EuDoCntrRlseStsVO[] tmpVOs = new EuDoCntrRlseStsVO[doCntrRlseSts.length];
			System.arraycopy(doCntrRlseSts, 0, tmpVOs, 0, tmpVOs.length);
			this.doCntrRlseSts = tmpVOs;
		}		
	}    

//    public EuDoRlseStsVO[] getEuDoRlseSts() {
//        return euDoRlseSts;
//    }

	//2015.04.10 Secure Coding 적용[CWE-496]
    public EuDoRlseStsVO[] getEuDoRlseSts() {
    	EuDoRlseStsVO[] tmpVOs = null;
		if (this.euDoRlseSts != null) {
			tmpVOs = new EuDoRlseStsVO[euDoRlseSts.length];
			System.arraycopy(euDoRlseSts, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;		
	} 
    
//    public void setEuDoRlseSts(EuDoRlseStsVO[] euDoRlseSts) {
//        this.euDoRlseSts = euDoRlseSts;
//    }
    
	//2015.04.10 Secure Coding 적용[CWE-496]
    public void setEuDoRlseSts(EuDoRlseStsVO[] euDoRlseSts) {
		if (euDoRlseSts != null) {
			EuDoRlseStsVO[] tmpVOs = new EuDoRlseStsVO[euDoRlseSts.length];
			System.arraycopy(euDoRlseSts, 0, tmpVOs, 0, tmpVOs.length);
			this.euDoRlseSts = tmpVOs;
		}		
	}     
    
    /**
     * @return the doNo
     */
    public String getDoNo() {
        return doNo;
    }

    /**
     * @param doNo the doNo to set
     */
    public void setDoNo(String doNo) {
        this.doNo = doNo;
    }    
    
    public String getSplitFlg() {
        return splitFlg;
    }

    public void setSplitFlg(String splitFlg) {
        this.splitFlg = splitFlg;
    }    
    
    public DoRlseVO getGenDoRlse() {
        return genDoRlse;
    }

    public void setGenDoRlse(DoRlseVO genDoRlse) {
        this.genDoRlse = genDoRlse;
    }
    
}