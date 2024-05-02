/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : PortRestrictionBCImpl.java
 *@FileTitle : DG Restriction by Port (Creation)
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.05.26
 *@LastModifier : 장강철
 *@LastVersion : 1.0
 * 2009.05.26 장강철
 * 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.scg.dangerouscargorestriction.portrestriction.basic;

import java.util.ArrayList;
import java.util.List;

import com.hanjin.apps.alps.vop.scg.dangerouscargorestriction.portrestriction.integration.PortRestrictionDBDAO;
import com.hanjin.apps.alps.vop.scg.dangerouscargorestriction.portrestriction.vo.PortRestriction2VO;
import com.hanjin.apps.alps.vop.scg.dangerouscargorestriction.portrestriction.vo.PortRestrictionDtlVO;
import com.hanjin.apps.alps.vop.scg.dangerouscargorestriction.portrestriction.vo.PortRestrictionVO;
import com.hanjin.apps.alps.vop.scg.dangerouscargorestriction.portrestriction.vo.PortRestrictonOptionVO;
import com.hanjin.apps.alps.vop.scg.dangerouscargorestriction.portrestriction.vo.SearchScgImdgPortRstrDtlVO;
import com.hanjin.apps.alps.vop.scg.dangerouscargorestriction.portrestriction.vo.VopScg004ContainVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.util.object.ObjectCloner;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.ScgImdgPortRstrDtlVO;
import com.hanjin.syscommon.common.table.ScgImdgPortRstrVO;

/**
 * ALPS-DangerousCargoRestriction Business Logic Basic Command implementation<br>
 * - ALPS-DangerousCargoRestriction에 대한 비지니스 로직을 처리한다.<br>
 * 
 * @author jang kang cheol
 * @see VOP_SCG_0005EventResponse,PortRestrictionBC 각 DAO 클래스 참조
 * @since J2EE 1.6
 */
public class PortRestrictionBCImpl extends BasicCommandSupport implements
        PortRestrictionBC {

    // Database Access Object
    private transient PortRestrictionDBDAO dbDao = null;
    
    /**
     * PortRestrictionBCImpl 객체 생성<br>
     * PortRestrictionDBDAO를 생성한다.<br>
     */
    public PortRestrictionBCImpl() {
        dbDao = new PortRestrictionDBDAO();
    }

 
    /**
     * 
     * Port Restriction 저장 처리 <br>
     * 
     * @param VopScg004ContainVO vopScg004ContainVO
     * @param SignOnUserAccount signOnUserAccount
     * @return String
     * @throws EventException
     */     
    public String managePortRestriction(VopScg004ContainVO vopScg004ContainVO,
            SignOnUserAccount signOnUserAccount) throws EventException {
        try {
            List<PortRestrictionDtlVO> insertVoList = new ArrayList<PortRestrictionDtlVO>();
             
            PortRestrictionVO[] prohscgImdgPortRstrVOs = vopScg004ContainVO
                    .getProhscgImdgPortRstrVOs();
            SearchScgImdgPortRstrDtlVO[] competScgImdgPortRstrDtlVOs = vopScg004ContainVO
                    .getCompetScgImdgPortRstrDtlVOs();
            SearchScgImdgPortRstrDtlVO[] quantiScgImdgPortRstrDtlVOs = vopScg004ContainVO
                    .getQuantiScgImdgPortRstrDtlVOs();

            SearchScgImdgPortRstrDtlVO[] explanScgImdgPortRstrDtlVOs = vopScg004ContainVO
                    .getExplanScgImdgPortRstrDtlVOs();
            PortRestrictionVO[] directLosdScgImdgPortRstrVOs = vopScg004ContainVO
                    .getDirectLosdScgImdgPortRstrVOs();

            PortRestrictonOptionVO condition = vopScg004ContainVO.getCondition();
             
            PortRestrictionVO scgImdgPortRstrVO = new PortRestrictionVO();
            ScgImdgPortRstrDtlVO scgImdgPortRstrDtlVO = new ScgImdgPortRstrDtlVO();
            /*****************************************************************************************
             * SCG_IMDG_PORT_RSTR - Prohibition 처리 Sheet 1
             *****************************************************************************************/
            scgImdgPortRstrVO.setIbflag(prohscgImdgPortRstrVOs[0].getIbflag());
            scgImdgPortRstrVO.setPortCd(condition.getPortCd());
            String imdgPortRstrSeq = "";

            /************************** SEQ 값이 존재 하지 않으면 등록모드 **************************************/
            if (condition.getImdgPortRstrSeq().equals("")) {
                List<PortRestrictionVO> checList = null;
                PortRestrictonOptionVO checkCond = new PortRestrictonOptionVO();
                ObjectCloner.build(condition, checkCond);
 
                /************ clss로 셋팅시. ***********/
                if (condition.getImdgUnNo() == "") {
                    checkCond.setImdgUnNo("");
                    checkCond.setImdgUnNoSeq("");
                    checList = searchPortRestriction(checkCond);
                } else {
                    /************ UNNO 로 셋팅시. ***********/
                    checkCond.setImdgClssCd("");
                    checList = searchPortRestriction(checkCond);
                }
                if (checList.size() != 0) {
                    throw new EventException(new ErrorHandler("SCG50005",
                            new String[] { "Data" }).getMessage());//중복된자료 존재.
                }
                imdgPortRstrSeq = dbDao.getImdgPortRstrSeq(condition
                        .getPortCd());

            } else {
                imdgPortRstrSeq = condition.getImdgPortRstrSeq();
            }
            scgImdgPortRstrVO.setImdgPortRstrSeq(imdgPortRstrSeq);
            scgImdgPortRstrVO.setImdgPortRstrExptFlg("Y");
            scgImdgPortRstrVO.setImdgUnNo(condition.getImdgUnNo());
            scgImdgPortRstrVO.setImdgUnNoSeq(condition.getImdgUnNoSeq()); // condition.getImdgUnNoSeq()

            String sImdgClssCd = "";
            if (condition.getImdgClssCd().equals("")) {
                String[] classcd = dbDao.getImdgClssCd(condition.getImdgUnNo(),
                        condition.getImdgUnNoSeq());
                if (!classcd[0].equals("")) {
                    sImdgClssCd = classcd[0];
                }
            } else {
                sImdgClssCd = condition.getImdgClssCd();
            }
            scgImdgPortRstrVO.setImdgClssCd(sImdgClssCd);

            scgImdgPortRstrVO.setProhiLodFlg(prohscgImdgPortRstrVOs[0]
                    .getProhiLodFlg().equals("1") ? "Y" : "N");
            scgImdgPortRstrVO.setProhiDchgFlg(prohscgImdgPortRstrVOs[0]
                    .getProhiDchgFlg().equals("1") ? "Y" : "N");
            scgImdgPortRstrVO.setProhiTsFlg(prohscgImdgPortRstrVOs[0]
                    .getProhiTsFlg().equals("1") ? "Y" : "N");
            scgImdgPortRstrVO.setProhiPassFlg(prohscgImdgPortRstrVOs[0]
                    .getProhiPassFlg().equals("1") ? "Y" : "N");

            scgImdgPortRstrVO.setProhiDyTmOpFlg(prohscgImdgPortRstrVOs[0]
                    .getProhiDyTmOpFlg().equals("1") ? "Y" : "N");
            scgImdgPortRstrVO.setProhiDyTmInlndTzFlg(prohscgImdgPortRstrVOs[0]
                    .getProhiDyTmInlndTzFlg().equals("1") ? "Y" : "N");
            scgImdgPortRstrVO.setProhiPortFlg(prohscgImdgPortRstrVOs[0]
                    .getProhiPortFlg().equals("1") ? "Y" : "N");
            scgImdgPortRstrVO.setProhiNgtFlg(prohscgImdgPortRstrVOs[0]
                    .getProhiNgtFlg().equals("1") ? "Y" : "N");

            /*****************************************************************************************
             * SCG_IMDG_PORT_RSTR, SCG_IMDG_PORT_RSTR_DTL - Direct Load 처리 Sheet
             * 5
             *****************************************************************************************/
            scgImdgPortRstrVO.setDirLodFlg(directLosdScgImdgPortRstrVOs[0]
                    .getDirLodFlg().equals("1") ? "Y" : "N");
            scgImdgPortRstrVO.setDirDchgFlg(directLosdScgImdgPortRstrVOs[0]
                    .getDirDchgFlg().equals("1") ? "Y" : "N");
            scgImdgPortRstrVO.setDirTsFlg(directLosdScgImdgPortRstrVOs[0]
                    .getDirTsFlg().equals("1") ? "Y" : "N");

            scgImdgPortRstrVO.setProhiPinspFlg(directLosdScgImdgPortRstrVOs[0]
                    .getProhiPinspFlg().equals("1") ? "Y" : "N");
            scgImdgPortRstrVO.setXtraHndlChgFlg(directLosdScgImdgPortRstrVOs[0]
                    .getXtraHndlChgFlg().equals("1") ? "Y" : "N");
            scgImdgPortRstrVO.setSftGadFlg(directLosdScgImdgPortRstrVOs[0]
                    .getSftGadFlg().equals("1") ? "Y" : "N");
            scgImdgPortRstrVO
                    .setKepSftDistIhbFlg(directLosdScgImdgPortRstrVOs[0]
                            .getKepSftDistIhbFlg().equals("1") ? "Y" : "N");
            scgImdgPortRstrVO
                    .setKepSftDistIhbDist(directLosdScgImdgPortRstrVOs[0]
                            .getKepSftDistIhbDist());
 
            scgImdgPortRstrDtlVO.setStoDys(directLosdScgImdgPortRstrVOs[0]
                    .getStoDys());
            /*****************************************************************************************
             * SCG_IMDG_PORT_RSTR_DTL - Competent Authority 처리 Sheet 2
             *****************************************************************************************/
 
            /*****************************************************************************************
             * SCG_IMDG_PORT_RSTR_DTL - Max. Quantity 처리 Sheet 3
             *****************************************************************************************/
            scgImdgPortRstrDtlVO.setTmlMaxQty(competScgImdgPortRstrDtlVOs[0]
                    .getTmlMaxQty());
            scgImdgPortRstrDtlVO.setObrdMaxQty(competScgImdgPortRstrDtlVOs[0]
                    .getObrdMaxQty());
            scgImdgPortRstrDtlVO
                    .setOneTmHndlMaxQty(competScgImdgPortRstrDtlVOs[0]
                            .getOneTmHndlMaxQty());
 
            scgImdgPortRstrVO.setRstrRmk(vopScg004ContainVO.getRstrRmk());

            /**************************************************************************
             * SCG_IMDG_PORT_RSTR 처리
             * 
             **************************************************************************/
            scgImdgPortRstrVO.setCreUsrId(signOnUserAccount.getUsr_id());
            scgImdgPortRstrVO.setUpdUsrId(signOnUserAccount.getUsr_id());
            dbDao.addPortRestriction(scgImdgPortRstrVO);
 

            /**************************************************************************
             * SCG_IMDG_PORT_RSTR_DTL 처리
             * 
             **************************************************************************/
            PortRestrictionDtlVO tmpDtlVO = null;
            // if ( scgImdgPortRstrVO.getIbflag().equals("I")){
            String[] aPortProhiTpCdYn = { scgImdgPortRstrVO.getProhiLodFlg(),
                    scgImdgPortRstrVO.getProhiDchgFlg(),
                    scgImdgPortRstrVO.getProhiTsFlg(),
                    scgImdgPortRstrVO.getProhiPassFlg() };// 0:Load, 1:DIS,
                                                          // 2:TS, 3:PASS
            String[] aPortProhiTpCd = { "L", "D", "T", "P" };// 0:Load, 1:DIS,
                                                             // 2:TS, 3:PASS

            String[] aImdgCmptnAuthCd = { condition.getLoadImdgCmptnAuthCd(),
                    condition.getDisImdgCmptnAuthCd(),
                    condition.getTsImdgCmptnAuthCd(),
                    condition.getPassImdgCmptnAuthCd() };

            String[] aTonOvrVolQty = {
                    competScgImdgPortRstrDtlVOs[0].getLoadTonOvrVolQty(),
                    competScgImdgPortRstrDtlVOs[0].getDisTonOvrVolQty(),
                    competScgImdgPortRstrDtlVOs[0].getTsTonOvrVolQty(),
                    competScgImdgPortRstrDtlVOs[0].getPassTonOvrVolQty() };

            String[] aNdTmHrs = {
                    competScgImdgPortRstrDtlVOs[0].getLoadNdTmHrs(),
                    competScgImdgPortRstrDtlVOs[0].getDisNdTmHrs(),
                    competScgImdgPortRstrDtlVOs[0].getTsNdTmHrs(),
                    competScgImdgPortRstrDtlVOs[0].getPassNdTmHrs() };

            /*****************************************************************************************
             * SCG_IMDG_PORT_RSTR_DTL - Text Explanation 처리 Sheet 4
             *****************************************************************************************/

            String[] aTxtExp = {
                    explanScgImdgPortRstrDtlVOs[0].getLoadTxtDesc(),
                    explanScgImdgPortRstrDtlVOs[0].getDisTxtDesc(),
                    explanScgImdgPortRstrDtlVOs[0].getTsTxtDesc(),
                    explanScgImdgPortRstrDtlVOs[0].getPassTxtDesc() };

            String[] aTmlMaxQty = {
                    quantiScgImdgPortRstrDtlVOs[0].getLoadTmlMaxQty(),
                    quantiScgImdgPortRstrDtlVOs[0].getDisTmlMaxQty(),
                    quantiScgImdgPortRstrDtlVOs[0].getTsTmlMaxQty(),
                    quantiScgImdgPortRstrDtlVOs[0].getPassTmlMaxQty() };

            String[] aObrdMaxQty = {
                    quantiScgImdgPortRstrDtlVOs[0].getLoadObrdMaxQty(),
                    quantiScgImdgPortRstrDtlVOs[0].getDisObrdMaxQty(),
                    quantiScgImdgPortRstrDtlVOs[0].getTsObrdMaxQty(),
                    quantiScgImdgPortRstrDtlVOs[0].getPassObrdMaxQty() };

            String[] aOneTmHndlMaxQty = {
                    quantiScgImdgPortRstrDtlVOs[0].getLoadOneTmHndlMaxQty(),
                    quantiScgImdgPortRstrDtlVOs[0].getDisOneTmHndlMaxQty(),
                    quantiScgImdgPortRstrDtlVOs[0].getTsOneTmHndlMaxQty(),
                    quantiScgImdgPortRstrDtlVOs[0].getPassOneTmHndlMaxQty() };
            String[] aDysStoFlg = {
                    directLosdScgImdgPortRstrVOs[0].getLoadDysStoFlg().equals(
                            "1") ? "Y" : "N",
                    directLosdScgImdgPortRstrVOs[0].getDisDysStoFlg().equals(
                            "1") ? "Y" : "N",
                    directLosdScgImdgPortRstrVOs[0].getTsDysStoFlg()
                            .equals("1") ? "Y" : "N", "" };
            String[] aStoDys = {
                    directLosdScgImdgPortRstrVOs[0].getLoadStoDys(),
                    directLosdScgImdgPortRstrVOs[0].getDisStoDys(),
                    directLosdScgImdgPortRstrVOs[0].getTsStoDys(), "" };
            for (int i = 0; i < aPortProhiTpCd.length; i++) {
                // if( PortProhiTpCd[i].equals("Y")){ continue;}//금지 항목
                tmpDtlVO = new PortRestrictionDtlVO();
                tmpDtlVO.setPortCd(scgImdgPortRstrVO.getPortCd());
                tmpDtlVO.setImdgPortRstrSeq(scgImdgPortRstrVO
                        .getImdgPortRstrSeq());
                tmpDtlVO.setPortProhiTpCd(aPortProhiTpCd[i]);

                tmpDtlVO.setImdgCmptnAuthCd(aImdgCmptnAuthCd[i]);

                tmpDtlVO.setTxtDesc(aTxtExp[i]);// Text Explanation

                tmpDtlVO.setDysStoFlg(aDysStoFlg[i]);// Text Explanation
                tmpDtlVO.setStoDys(aStoDys[i].equals("") ? "0" : aStoDys[i]);
                tmpDtlVO.setCreUsrId(signOnUserAccount.getUsr_id());
                tmpDtlVO.setUpdUsrId(signOnUserAccount.getUsr_id());

                tmpDtlVO.setTmlMaxQty(aTmlMaxQty[i]);
                tmpDtlVO.setObrdMaxQty(aObrdMaxQty[i]);
                tmpDtlVO.setOneTmHndlMaxQty(aOneTmHndlMaxQty[i]);

                if (aPortProhiTpCdYn[i].equals("N")) {
                    tmpDtlVO.setTonOvrVolQty(aTonOvrVolQty[i].equals("") ? "0"
                            : aTonOvrVolQty[i]);
                    tmpDtlVO.setNdTmHrs(aNdTmHrs[i].equals("") ? "0"
                            : aNdTmHrs[i]);

 

                } else if (aPortProhiTpCdYn[i].equals("Y")) {
                    tmpDtlVO.setTonOvrVolQty("0");
                    tmpDtlVO.setNdTmHrs("0");
                    // tmpDtlVO.setTmlMaxQty( "0" );
                    // tmpDtlVO.setObrdMaxQty( "0" );
                    // tmpDtlVO.setOneTmHndlMaxQty( "0");

                }
                if (aPortProhiTpCd[i].equals("T")
                        || aPortProhiTpCd[i].equals("P")) {
                    tmpDtlVO.setOneTmHndlMaxQty("");
                }
                insertVoList.add(tmpDtlVO);
            }

            if (insertVoList.size() > 0) {
                dbDao.addPortRestrictionDetail(insertVoList);
            }

            return imdgPortRstrSeq;
        }catch(EventException ex){
            throw ex;
        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12192", new String[]{"Port Restriction"}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12192", new String[]{"Port Restriction"}).getMessage(), ex);
        }
    }
 
 

    /**
     * 
     * Port Restriction 조회<br>
     * 
     * @param  PortRestrictonOptionVO portRestrictonOptionVO
     * @return List<PortRestrictionVO> 
     * @throws EventException
     */ 
    public List<PortRestrictionVO> searchPortRestriction(
            PortRestrictonOptionVO portRestrictonOptionVO)
            throws EventException {
        try { 
            return dbDao.searchPortRestriction(portRestrictonOptionVO);
        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Port Restriction"}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Port Restriction"}).getMessage(), ex);
        }
    }

    /**
     * 
     * Port Restriction 상세 조회  <br>
     * 
     * @param  PortRestrictonOptionVO portRestrictonOptionVO
     * @return List<PortRestrictonOptionVO> 
     * @throws EventException
     */ 
    public List<PortRestrictionDtlVO> searchPortRestrictionDetail(
            PortRestrictonOptionVO portRestrictonOptionVO)
            throws EventException {
        try {
            return dbDao.searchPortRestrictionDetail(portRestrictonOptionVO);
        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Port Restriction"}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Port Restriction"}).getMessage(), ex);
        }
    }

    /**
     * 
     * Port Restriction 삭제 처리 <br>
     * 
     * @param  PortRestrictonOptionVO portRestrictonOptionVO
     * @throws DAOException
     * @throws EventException
     */  
    public void removePortRestriction(
            PortRestrictonOptionVO portRestrictonOptionVO ) throws EventException {
        try {

            dbDao.removePortRestrictionDetail(portRestrictonOptionVO);            
            dbDao.removePortRestriction(portRestrictonOptionVO);

        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12197", new String[]{"Port Restriction"}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12197", new String[]{"Port Restriction"}).getMessage(), ex);
        }
    }

    /**
     * UnNo, Seq 로 Class Cd 구하기 <br>
     * 
     * @param  String unno
     * @param  String seq
     * @return String[]
     * @throws EventException
     */ 
    public String[] getImdgClssCd(String Unno, String Seq)
            throws EventException {
        try {
            return dbDao.getImdgClssCd(Unno, Seq);
        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"UnNo Seq"}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"UnNo Seq"}).getMessage(), ex);
        }
    }

    /**
     * Port Restriction의  Save As 처리<br>
     * 
     * @param  PortRestrictionVO portRestrictionVO
     * @param  PortRestrictionVO[] portRestrictionVOs
     * @param  SignOnUserAccount signOnUserAccount
     * @return int
     * @throws EventException
     */ 
    public int managePortRestrictionSaveAs(PortRestrictionVO portRestrictionVO,PortRestrictionVO[] portRestrictionVOs,SignOnUserAccount signOnUserAccount) throws EventException {
    	int rslt = -1;
        try {

            String optClass = portRestrictionVO.getSavTypeClassLabel();
            /******** portcd, class 코드로 존재여부 체크 후 존재시 에러 ****************/
            if (optClass.equals("class")) {

                for (int i = 0; i < portRestrictionVOs.length; i++) {
                    /********************* 검증용 조회 ************************/
                    PortRestrictonOptionVO pImdgPortRstrVO = new PortRestrictonOptionVO();
                    pImdgPortRstrVO.setPortCd(portRestrictionVOs[i].getPortCd());
                    pImdgPortRstrVO.setImdgClssCd(portRestrictionVO.getImdgClssCd());
                    pImdgPortRstrVO.setImdgUnNo("");
                    List<PortRestrictionVO> listCheckScgImdgPortRstr = dbDao.searchPortRestriction(pImdgPortRstrVO);

                    /*********** 없는 거 확인후 INSERT **********/
                    if (listCheckScgImdgPortRstr.size() == 0) {
                        // INSERT imdg_port_rstr_seq

                        ScgImdgPortRstrVO saveScgImdgPortRstrVO = new ScgImdgPortRstrVO();

                        String sNewPortCd = portRestrictionVOs[i].getPortCd();
                        String sNewImdgPortRstrSeq = dbDao.getImdgPortRstrSeq(sNewPortCd);

                        /***** Target Info *********/
                        saveScgImdgPortRstrVO.setImdgUnNo("");
                        saveScgImdgPortRstrVO.setImdgUnNoSeq("");
                        saveScgImdgPortRstrVO.setImdgClssCd(pImdgPortRstrVO.getImdgClssCd());

                        saveScgImdgPortRstrVO.setCreUsrId(signOnUserAccount.getUsr_id());
                        /***** Source Info *********/
                        saveScgImdgPortRstrVO.setPortCd(portRestrictionVO.getPortCd());
                        saveScgImdgPortRstrVO.setImdgPortRstrSeq(portRestrictionVO.getImdgPortRstrSeq());

                        dbDao.modifyPortRestrictionSaveAs(saveScgImdgPortRstrVO, sNewPortCd,sNewImdgPortRstrSeq);
                        /************************* 디테일정보 *****************************/
                        ScgImdgPortRstrDtlVO saveScgImdgPortRstrDtlVO = new ScgImdgPortRstrDtlVO();
                        saveScgImdgPortRstrDtlVO.setPortCd(portRestrictionVO.getPortCd());
                        saveScgImdgPortRstrDtlVO.setImdgPortRstrSeq(portRestrictionVO.getImdgPortRstrSeq());
                        saveScgImdgPortRstrDtlVO.setCreUsrId(signOnUserAccount.getUsr_id());
                        dbDao.modifyPortRestrictionSaveAsDtl(saveScgImdgPortRstrDtlVO, sNewPortCd,sNewImdgPortRstrSeq);

                    } else {
                    	rslt = i;
                    	break;
//                        throw new EventException(new ErrorHandler("SCG50005",
//                                new String[] { "Data" }).getMessage());
                    }
                }
            }
            /******** portcd, class, Unno, Unno Seq 코드로 존재여부 체크 후 존재시 에러 ****************/
            if (optClass.equals("unno")) {
                for (int i = 0; i < portRestrictionVOs.length; i++) {
                    /********************* 검증용 조회 ************************/
                    PortRestrictonOptionVO pImdgPortRstrVO = new PortRestrictonOptionVO();
                    pImdgPortRstrVO.setPortCd(portRestrictionVOs[i]
                            .getPortCd());

                    pImdgPortRstrVO.setImdgUnNo(portRestrictionVO.getImdgUnNo());
                    pImdgPortRstrVO.setImdgUnNoSeq(portRestrictionVO.getImdgUnNoSeq());

                    List<PortRestrictionVO> listCheckScgImdgPortRstr = dbDao
                            .searchPortRestriction(pImdgPortRstrVO);

                    String sImdgClssCd = "";
                    if (portRestrictionVO.getImdgClssCd().equals("")) {
                        String[] classcd = dbDao.getImdgClssCd(portRestrictionVO
                                .getImdgUnNo(), portRestrictionVO.getImdgUnNoSeq());
                        if (!classcd[0].equals("")) {
                            sImdgClssCd = classcd[0];
                        }
                    } else {
                        sImdgClssCd = portRestrictionVO.getImdgClssCd();
                    }
                    pImdgPortRstrVO.setImdgClssCd(sImdgClssCd);

                    /*********** 없는 거 확인후 INSERT **********/
                    if (listCheckScgImdgPortRstr.size() == 0) {
                        // INSERT imdg_port_rstr_seq

                        ScgImdgPortRstrVO saveScgImdgPortRstrVO = new ScgImdgPortRstrVO();

                        String sNewPortCd = portRestrictionVOs[i]
                                .getPortCd();
                        String sNewImdgPortRstrSeq = dbDao
                                .getImdgPortRstrSeq(sNewPortCd);

                        /***** Target Info *********/
                        saveScgImdgPortRstrVO.setImdgUnNo(pImdgPortRstrVO
                                .getImdgUnNo());
                        saveScgImdgPortRstrVO.setImdgUnNoSeq(pImdgPortRstrVO
                                .getImdgUnNoSeq());
                        saveScgImdgPortRstrVO.setImdgClssCd(pImdgPortRstrVO
                                .getImdgClssCd());

                        saveScgImdgPortRstrVO.setCreUsrId(signOnUserAccount.getUsr_id());
                        /***** Source Info *********/
                        saveScgImdgPortRstrVO.setPortCd(portRestrictionVO.getPortCd());
                        saveScgImdgPortRstrVO.setImdgPortRstrSeq(portRestrictionVO
                                .getImdgPortRstrSeq());

                        dbDao.modifyPortRestrictionSaveAs(
                                saveScgImdgPortRstrVO, sNewPortCd,
                                sNewImdgPortRstrSeq);
                        /************************* 디테일정보 *****************************/
                        ScgImdgPortRstrDtlVO saveScgImdgPortRstrDtlVO = new ScgImdgPortRstrDtlVO();
                        saveScgImdgPortRstrDtlVO.setPortCd(portRestrictionVO
                                .getPortCd());
                        saveScgImdgPortRstrDtlVO.setImdgPortRstrSeq(portRestrictionVO
                                .getImdgPortRstrSeq());
                        saveScgImdgPortRstrDtlVO.setCreUsrId(signOnUserAccount
                                .getUsr_id());
                        dbDao.modifyPortRestrictionSaveAsDtl(
                                saveScgImdgPortRstrDtlVO, sNewPortCd,
                                sNewImdgPortRstrSeq);

                    } else {
                    	rslt = i;
                    	break;
//                        throw new EventException(new ErrorHandler("SCG50005",
//                                new String[] { "Data" }).getMessage());
 
                    }
                }
            }
        } catch (EventException ex) {
            throw ex;
        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12192", new String[]{"Port Restriction"}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12192", new String[]{"Port Restriction"}).getMessage(), ex);
        }
        return rslt;
    }

    /**
     * Port & VSL OPR’s Carrier Restriction En-route 메인 조회 <br>
     * 
     * @param  PortRestrictionOptionVO portRestrictionOptionVO
     * @return List<ScgImdgCrrRstrVO> 
     * @throws EventException
     */ 
    /*
    public List<ScgImdgCrrRstrVO> searchCarrierEnRouteList(
            PortRestrictionOptionVO portRestrictionOptionVO) throws EventException {
        try {
            return dbDao.searchCarrierEnRouteList(portRestrictionOptionVO);
        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Carrier Restriction En-route"}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Carrier Restriction En-route"}).getMessage(), ex);
        }
    }
	*/
    
    /**
     * Port & VSL OPR’s Port Restriction En-route 메인 조회 <br>
     * 
     * @param  PortRestrictionOptionVO portRestrictionOptionVO
     * @return List<PortRestrictionOptionVO> 
     * @throws EventException
     */ 
    /*
    public List<PortRestrictionOptionVO> searchPortEnRouteList(
            PortRestrictionOptionVO portRestrictionOptionVO) throws EventException {
        try {
            return dbDao.searchPortEnRouteList(portRestrictionOptionVO);
        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Port & VSL OPR’s Port Restriction En-route"}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Port & VSL OPR’s Port Restriction En-route"}).getMessage(), ex);
        }
    }
    */
    
    /**
     * 
     * DG Prohibition Summary by Port 을 조회 합니다.<br>
     * 
     * @param  PortRestrictonOptionVO portRestrictonOptionVO
     * @return List<PortRestrictionVO> 
     * @throws EventException
     */ 
    public List<PortRestrictionVO> searchPortRestrictionSummary(
            PortRestrictonOptionVO portRestrictonOptionVO) throws EventException {
        try {
        	if( portRestrictonOptionVO.getOptclass().equals("class") ){
        		return dbDao.searchPortRestrictionClssSummary(portRestrictonOptionVO);  
            }else{                        
                if(portRestrictonOptionVO.getImdgUnNo().equals("")){
                	return dbDao.searchPortRestrictionNonUnNoSummary(portRestrictonOptionVO);  
                }else{
                    //UNNO조회 선택 AND UNNO KEY-IN
                	return dbDao.searchPortRestrictionUnNoSummary(portRestrictonOptionVO);  
                }
            }
        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"DG Prohibition Summary by Port"}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"DG Prohibition Summary by Port"}).getMessage(), ex);
        }
    }

    /**
     * 
     * DG Restriction Summary by Port 을 조회 합니다.<br>
     * 
     * @param  PortRestrictonOptionVO portRestrictonOptionVO
     * @return List<PortRestriction2VO> 
     * @throws EventException
     */ 
    public List<PortRestriction2VO> searchPortRestrictionSummary2(PortRestrictonOptionVO portRestrictonOptionVO) throws EventException {
        try {
        	if( portRestrictonOptionVO.getOptclass().equals("class") ){
        		return dbDao.searchDgRestrictionSummaryByPortClss(portRestrictonOptionVO);
            }else{
                return dbDao.searchDgRestrictionSummaryByPortUnno(portRestrictonOptionVO);
            }
        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"DG Restriction Summary by Port"}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"DG Restriction Summary by Port"}).getMessage(), ex);
        }
    }

}