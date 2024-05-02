/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : Edi324SendBCImpl.java
*@FileTitle : Edi324SendBCImpl
*Open Issues :
*Change history :
*@LastModifyDate : 2009-10-01
*@LastModifier : 전병석
*@LastVersion : 1.0
* 2009-10-01 전병석
* 1.0 최초 생성
* SCE_EDI_SEND_PRC Revision History    
=========================================================*/

package com.hanjin.apps.alps.esd.sce.edi324send.basic;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;


import com.hanjin.apps.alps.esd.sce.edi324send.integration.Edi324SendDBDAO;
import com.hanjin.apps.alps.esd.sce.edi324send.integration.Edi324SendEAIDAO;
import com.hanjin.apps.alps.esd.sce.edi324send.vo.Edi324SendVO;
import com.hanjin.apps.alps.esd.sce.edi324send.vo.SearchEdi324SendVO;
import com.hanjin.framework.component.common.AbstractValueObject;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.component.util.object.ObjectCloner;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;
import com.hanjin.syscommon.common.table.SceEdi324SndRsltVO;


/**
 * ENIS-SCE Business Logic ServiceCommand<br>
 * - ENIS-SCE에 대한 비지니스 트랜잭션을 처리한다.<br>
 * 
 * @author YJLEE
 * @see Edi324SendBC 참조
 * @since J2EE 1.4
 */
public class Edi324SendBCImpl extends BasicCommandSupport implements Edi324SendBC{
	private transient Edi324SendDBDAO dbDao = null;
	/**
	 * Edi324SendBCImpl 생성자<br>
	 * 
	 * @param 
	 * @exception
	 */
	public Edi324SendBCImpl() {
		dbDao = new Edi324SendDBDAO();
	}
	/**
	 * ESD_SCE_0056화면에서 호출된 정보를 기준으로 
	 * 발송대상의 기본정보를 보완후 조회후 324 발송 호출 Method.
	 * 
     * @param List<SearchEdi324SendVO> searchEdi324SendVO
     * @param String user_id
     * @throws EventException 
	 */

    public void edi324SendGetTarget(List<SearchEdi324SendVO> searchEdi324SendVO ,String user_id) throws EventException {
    	List<Edi324SendVO> edi324Vo_list = new ArrayList<Edi324SendVO>();
    	String[] snddetail_info = new String[14];
    	try{
    		for(int i=0 ; i <searchEdi324SendVO.size() ; i++){
    			log.debug("=== msg == " +searchEdi324SendVO.size() );
    			Edi324SendVO edi324Vo = new Edi324SendVO();
    			snddetail_info = dbDao.searchEdi324SendTarget(searchEdi324SendVO.get(i));
    			/*
    			 *  snddetail_info[0] = "VNDR_SEQ"; 
					snddetail_info[1] = "COP_NO";
					snddetail_info[2] = "COP_DTL_SEQ";
					snddetail_info[3] = "POL_DEP_ACT_DT";
					snddetail_info[4] = "POL_YD_CD";
					snddetail_info[5] = "VSL_CD";
					snddetail_info[6] = "SKD_VOY_NO";
					snddetail_info[7] = "SKD_DIR_CD";
					snddetail_info[8] = "BKG_NO";
					snddetail_info[9] = "CNTR_NO";
					snddetail_info[10] = "ORG_YD_CD";
					snddetail_info[11] = "DEST_YD_CD";
					snddetail_info[12] = "CRE_USR_ID"; <-- 따로 정의 
					snddetail_info[13] = "UPD_USR_ID"; <-- 따로 정의
    			 */
    			edi324Vo.setVndrSeq(snddetail_info[0]);
    			edi324Vo.setCopNo(snddetail_info[1]);
    			edi324Vo.setCopDtlSeq(snddetail_info[2]);
    			edi324Vo.setPolDepActDt(snddetail_info[3]);
    			edi324Vo.setPolYdCd(snddetail_info[4]);
    			edi324Vo.setVslCd(snddetail_info[5]);
    			edi324Vo.setSkdVoyNo(snddetail_info[6]);
    			edi324Vo.setSkdDirCd(snddetail_info[7]);
    			edi324Vo.setBkgNo(snddetail_info[8]);
    			edi324Vo.setCntrNo(snddetail_info[9]);
    			edi324Vo.setOrgYdCd(snddetail_info[10]);
    			edi324Vo.setDestYdCd(snddetail_info[11]);
    			edi324Vo.setCreUsrId(user_id);
    			edi324Vo.setUpdUsrId(user_id);
    			edi324Vo_list.add(edi324Vo);
     		}
    		edi324Send(edi324Vo_list);	
    	} catch (DAOException de) {
            log.error("err "+de.toString(),de);
    	 throw new EventException(de.getMessage());
    	}
    }	

	

	/**
	 * Edi324Send -  324 발송 Method.
	 * 정보를 채워서 저장후 발송을 위한 flatfile 만드는 함수를 호출을 한다.
     * @param List<Edi324SendVO> edi324Send
     * @throws EventException ... 
     */

    public void edi324Send(List<Edi324SendVO> edi324Send) throws EventException {


		int edi_snd_seq = 0;
		String[] detail_info = new String[24];
			
		try {
		List<SceEdi324SndRsltVO> result_list = new ArrayList<SceEdi324SndRsltVO>();
		
		
		if (edi324Send.size() >  0) {
			for (int i= 0 ; i< edi324Send.size(); i++){  // 넘어온 값의 빠진 부분을 채우면서 저장데이터를 만든어준다
				
				SceEdi324SndRsltVO sceEdi324SndRslt = new SceEdi324SndRsltVO();
				log.debug("\n --edi324Send.size()-  size()    : "+ edi324Send.size() +"\n");
				log.debug("\n ------  size()    : "+ i +"\n");
				log.debug("\n ------ vnder_seq  : "+edi324Send.get(i).getVndrSeq()+"\n");
				log.debug("\n ------ bkg_no     : "+edi324Send.get(i).getBkgNo()+"\n");
				log.debug("\n ------ cntr_no    : "+edi324Send.get(i).getCntrNo()+"\n");
				log.debug("\n ------ vsl_cd     : "+edi324Send.get(i).getVslCd()+"\n");
				log.debug("\n ------ skd_voy_no : "+edi324Send.get(i).getSkdVoyNo()+"\n");
				log.debug("\n ------ skd_voy_cd : "+edi324Send.get(i).getSkdDirCd()+"\n");
				log.debug("\n ------ cop_no     : "+edi324Send.get(i).getCopNo()+"\n");
				log.debug("\n ------ cre_usr_id : "+edi324Send.get(i).getCreUsrId()+"\n");
				/* 이미발송 된 내역인지 아닌지를 확인을 한다.
				 * 발송된 내역이 있으면 EDI_SND_SEQ를 하나씩 증가한다. 
				 * 기준이 되는 코드는 VNDR_SEQ, BKG_NO, CNTR_NO, VSL_CD,SKD_VOY_NO,SKD_DIR_CD 가 기준코드
				 * 
				*/
				edi_snd_seq = dbDao.searchEdi324SendCount(edi324Send.get(i).getVndrSeq() , edi324Send.get(i).getBkgNo() ,edi324Send.get(i).getCntrNo()
						    ,edi324Send.get(i).getVslCd(),edi324Send.get(i).getSkdVoyNo(),edi324Send.get(i).getSkdDirCd());
				log.debug("====EDI_SND_SEQ ===" + edi_snd_seq+ "\n");
//				/*
//				 * VDD별 발송내역을 만들어서  YYYYMMDD-VVDSEQ갯수로 저장을 한다.
//				 */
//				first_snd_id = 
//				edi_snd_id = dbDao.searchEdi324EdiSndId();
//				log.debug("====EDI_SND_ID ===" + edi_snd_id+ "\n");
				
				detail_info = dbDao.searchEdi324EdiSendDetailInfo(edi324Send.get(i).getCopNo() ,edi324Send.get(i).getOrgYdCd() , edi324Send.get(i).getDestYdCd());
				/*
		            detail_info[0] =  LLOYD_VSL_NO 
					detail_info[1] =  VSL_NM
					detail_info[2] =  POD_YD_CD
					detail_info[3] =  POD_NM
					detail_info[4] =  ACT_CD
					detail_info[5] =  POD_ESTM_ARR_DT
					detail_info[6] =  POD_ESTM_ARR_GDT
					detail_info[7] =  BL_NO
					detail_info[8] =  CNTR_WGT
					detail_info[9] =  CNTR_WGT_UT_CD
					detail_info[10] = CNTR_LBS_WGT
					detail_info[11] = CNTR_TPSZ_CD
					detail_info[12] = CNTR_LEN
					detail_info[13] = CNTR_HGT
					detail_info[14] = CNTR_SEAL_NO
					detail_info[15] = DG_FLG
					detail_info[16] = CNTR_NO
					detail_info[17] = ORG_YD_LOC_CTY_NM
					detail_info[18] = ORG_YD_LOC_STE_CD
					detail_info[19] = ORG_LOC_NM
					detail_info[20] = DST_YD_LOC_CTY_NM
					detail_info[21] = DST_YD_LOC_STE_CD
					detail_info[22] = DST_LOC_NM
			   */
				sceEdi324SndRslt.setVndrSeq(edi324Send.get(i).getVndrSeq());
				sceEdi324SndRslt.setBkgNo(edi324Send.get(i).getBkgNo());
				sceEdi324SndRslt.setCntrNo(edi324Send.get(i).getCntrNo());
				sceEdi324SndRslt.setVslCd(edi324Send.get(i).getVslCd());
				sceEdi324SndRslt.setSkdVoyNo(edi324Send.get(i).getSkdVoyNo());
				sceEdi324SndRslt.setSkdDirCd(edi324Send.get(i).getSkdDirCd());
				sceEdi324SndRslt.setEdiSndSeq(Integer.toString(edi_snd_seq));
			//	sceEdi324SndRslt.setEdiSndId(edi_snd_id);
				// 화면에서 재전송
				if("324_Batch".equals(edi324Send.get(i).getCreUsrId())) {
					sceEdi324SndRslt.setMnlFlg("N");	
				}else {//배치에서 전송
					sceEdi324SndRslt.setMnlFlg("Y");
				}
				//처음은 S으로 셋팅 , 발송후 'Y', 실패 : N
				sceEdi324SndRslt.setEdiSndTpCd("S");
				//처음은 Saved ,발송후 'SUCESS' , 실패 : 'Fail'
				sceEdi324SndRslt.setEdiSndRmk("Saved");
				sceEdi324SndRslt.setCopNo(edi324Send.get(i).getCopNo());
				sceEdi324SndRslt.setLloydVslNo(detail_info[0]);
				sceEdi324SndRslt.setVslNm(detail_info[1]);
				sceEdi324SndRslt.setPolYdCd(edi324Send.get(i).getPolYdCd());
				sceEdi324SndRslt.setPolDepActDt(edi324Send.get(i).getPolDepActDt());
				sceEdi324SndRslt.setPodYdCd(detail_info[2]);
				sceEdi324SndRslt.setPodNm(detail_info[3]);
				sceEdi324SndRslt.setPodEstmArrDt(detail_info[5]);
				sceEdi324SndRslt.setPodEstmArrGdt(detail_info[6]);
				sceEdi324SndRslt.setBlNo(edi324Send.get(i).getBkgNo());
				sceEdi324SndRslt.setCntrWgt(detail_info[8]);
				sceEdi324SndRslt.setCntrLbsWgt(detail_info[10]);
				sceEdi324SndRslt.setCntrWgtUtCd(detail_info[9]);
				sceEdi324SndRslt.setCntrTpszCd(detail_info[11]);
				sceEdi324SndRslt.setCntrLen(detail_info[12]);
				sceEdi324SndRslt.setCntrHgt(detail_info[13]);
				sceEdi324SndRslt.setCntrSealNo(detail_info[14]);
				sceEdi324SndRslt.setOrgYdCd(edi324Send.get(i).getOrgYdCd());
				sceEdi324SndRslt.setDestYdCd(edi324Send.get(i).getDestYdCd());
				sceEdi324SndRslt.setDgFlg(detail_info[15]);
				sceEdi324SndRslt.setCreUsrId(edi324Send.get(i).getCreUsrId());
				sceEdi324SndRslt.setUpdUsrId(edi324Send.get(i).getUpdUsrId());
				sceEdi324SndRslt.setActCd(detail_info[4]);
				sceEdi324SndRslt.setOrgYdLocCtyNm(detail_info[17]);
				sceEdi324SndRslt.setOrgYdLocSteCd(detail_info[18]);
				sceEdi324SndRslt.setOrgLocNm(detail_info[19]);
				sceEdi324SndRslt.setDestYdLocCtyNm(detail_info[20]);
				sceEdi324SndRslt.setDestYdLocSteCd(detail_info[21]);
				sceEdi324SndRslt.setDestLocNm(detail_info[22]);
			
				//저장 
				dbDao.addSceEdi324SndRslt(sceEdi324SndRslt);
				
			//	list.add(sceEdi324SndRslt);
				
		    }
			// 발송할 대상을 VVD 별로 순서대로 가져온다. 
			result_list = dbDao.searchGetTagretVVD();
	
			createFlatFile(result_list);
			
		}
			
			
   	} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage());

    } 
   	
   	
  }//edi324Send Method 끝 !!
    


    /**
     * creatFlatFile 해당 조건에 기한 전문을 만들어 기록및 전송함.
     * 즉, Flat File 전문 생성.
     * @param List<SceEdi324SndRsltVO> sceEdi324SndrsltVo
     * @return String
     * @throws EventException
     */
    private String createFlatFile(List<SceEdi324SndRsltVO> sceEdi324SndrsltVo
			                  ) throws EventException {
      String result = "";
      String main = "";
      String cntr_info ="";
      String vsl_cd = "";
	  String skd_voy_no ="";
	  String skd_dir_cd ="";
	  String lloyd_vsl_no ="";
	  String vsl_nm = "";
	  String pod_yd_cd ="";
	  String pod_nm ="";
	  String pod_estm_arr_dt ="";
	  String vndrSeq = "";
	  String updUsrId = "";
	  String edi_snd_id = null;
	  String edi_snd_idx = null;
	  int edi_snd_id1 = 0;
	  String[] edi_snd= null;
	  String cust_trd_prnr_id = "";
	  String flt_file_ref_no = "";
     /*
       * 똑같은 VVD가 몇개가 있는지 확인을 한다.
       */
	  try {
	  List<SceEdi324SndRsltVO> list1 = new ArrayList<SceEdi324SndRsltVO>();
	  SceEdi324SndRsltVO sceEdi324SndRslt = new SceEdi324SndRsltVO();
	 
      log.debug("=== 길이" + sceEdi324SndrsltVo.size() );
      if(sceEdi324SndrsltVo.size() > 0 ){
    	  /* 비교할 초기값을 셋팅을 한다.
    	   * 발송 될 형식에 맞게 값을 지정을 해서 초기값을 셋팅 
    	   */
    	  vsl_cd = sceEdi324SndrsltVo.get(0).getVslCd();
		  skd_voy_no =sceEdi324SndrsltVo.get(0).getSkdVoyNo();
		  skd_dir_cd =sceEdi324SndrsltVo.get(0).getSkdDirCd();
		  lloyd_vsl_no = sceEdi324SndrsltVo.get(0).getLloydVslNo();
		  vsl_nm = sceEdi324SndrsltVo.get(0).getVslNm();
		  pod_yd_cd =sceEdi324SndrsltVo.get(0).getPodYdCd();
		  pod_nm =sceEdi324SndrsltVo.get(0).getPodNm();
		  pod_estm_arr_dt =sceEdi324SndrsltVo.get(0).getPodEstmArrDt();
		  vndrSeq = sceEdi324SndrsltVo.get(0).getVndrSeq();
		  updUsrId = sceEdi324SndrsltVo.get(0).getUpdUsrId();
		  
		  sceEdi324SndRslt.setVslCd(vsl_cd);
		  sceEdi324SndRslt.setSkdVoyNo(skd_voy_no);
		  sceEdi324SndRslt.setSkdDirCd(skd_dir_cd);
		  sceEdi324SndRslt.setLloydVslNo(lloyd_vsl_no);
		  sceEdi324SndRslt.setVslNm(vsl_nm);
		  sceEdi324SndRslt.setPodYdCd(pod_yd_cd);
		  sceEdi324SndRslt.setPodNm(pod_nm);
		  sceEdi324SndRslt.setPodEstmArrDt(pod_estm_arr_dt);
		  sceEdi324SndRslt.setVndrSeq(vndrSeq);		    
		  sceEdi324SndRslt.setUpdUsrId(updUsrId);
			/*
			 * VDD별 발송내역을 만들어서  YYYYMMDD-VVDSEQ갯수로 저장을 한다.
			 */
			edi_snd_id = dbDao.searchEdi324EdiSndId();
			log.debug("===VVD원 변경===" + 0);
	  		log.debug("===VVD원 변경===" + vsl_cd);
	  		log.debug("===VVD원 변경===" + skd_voy_no);
	  		log.debug("===VVD원 변경===" + skd_dir_cd);
	  		log.debug("===VVD원 변경===" + edi_snd_id);
			sceEdi324SndRslt.setEdiSndId(edi_snd_id);
			
   		 list1.add(sceEdi324SndRslt);
		   for (int i  = 0 ; i < sceEdi324SndrsltVo.size() ; i++ ) {
			   // 새로운 VVD가 보여질때는 해당 VVD 정보를 list1에 담는다.
    		  	if (!(vsl_cd.equals(sceEdi324SndrsltVo.get(i).getVslCd()) && skd_voy_no.equals(sceEdi324SndrsltVo.get(i).getSkdVoyNo()) && skd_dir_cd.equals(sceEdi324SndrsltVo.get(i).getSkdDirCd()))){
    		  		sceEdi324SndRslt = new SceEdi324SndRsltVO();
    		  		vsl_cd =  sceEdi324SndrsltVo.get(i).getVslCd();
    		  		skd_voy_no =sceEdi324SndrsltVo.get(i).getSkdVoyNo();
    		  		skd_dir_cd =sceEdi324SndrsltVo.get(i).getSkdDirCd();
    		  		lloyd_vsl_no = sceEdi324SndrsltVo.get(i).getLloydVslNo();
    		  		vsl_nm = sceEdi324SndrsltVo.get(i).getVslNm();
    				pod_yd_cd =sceEdi324SndrsltVo.get(i).getPodYdCd();
    				pod_nm =sceEdi324SndrsltVo.get(i).getPodNm();
    				pod_estm_arr_dt =sceEdi324SndrsltVo.get(i).getPodEstmArrDt();
    				vndrSeq = sceEdi324SndrsltVo.get(i).getVndrSeq();
    				updUsrId = sceEdi324SndrsltVo.get(i).getUpdUsrId();
    				  
    				  sceEdi324SndRslt.setVslCd(vsl_cd);
    				  sceEdi324SndRslt.setSkdVoyNo(skd_voy_no);
    				  sceEdi324SndRslt.setSkdDirCd(skd_dir_cd);
    				  sceEdi324SndRslt.setLloydVslNo(lloyd_vsl_no);
    				  sceEdi324SndRslt.setVslNm(vsl_nm);
    				  sceEdi324SndRslt.setPodYdCd(pod_yd_cd);
    				  sceEdi324SndRslt.setPodNm(pod_nm);
    				  sceEdi324SndRslt.setPodEstmArrDt(pod_estm_arr_dt);
    				  sceEdi324SndRslt.setVndrSeq(vndrSeq);	    
    				  sceEdi324SndRslt.setUpdUsrId(updUsrId);
    					/*
    					 * VDD별 발송내역을 만들어서  YYYYMMDD-VVDSEQ갯수로 저장을 한다.
    					 */
    				    edi_snd = edi_snd_id.split("-");
    				    edi_snd_id1 = Integer.parseInt(edi_snd[1]) + 1;
    				    log.debug("=snd_id 증가==="+ edi_snd_id);
    				    if (edi_snd_id1 > 99 && edi_snd_id1 < 1000){
    				    	edi_snd_idx = "0" + Integer.toString(edi_snd_id1);
    				    }else if (edi_snd_id1 > 9 && edi_snd_id1 < 100) {
    				    	edi_snd_idx = "00" + Integer.toString(edi_snd_id1);
    				    }else if (edi_snd_id1 < 10) {
    				    	edi_snd_idx = "000" + Integer.toString(edi_snd_id1);
    				    }
    				    edi_snd_id = edi_snd[0]+"-"+ edi_snd_idx;
    				    
    					sceEdi324SndRslt.setEdiSndId(edi_snd_id);
    					log.debug("===VVD 변경===" + i);
        		  		log.debug("===VVD 변경===" + vsl_cd);
        		  		log.debug("===VVD 변경===" + skd_voy_no);
        		  		log.debug("===VVD 변경===" + skd_dir_cd);
        		  		log.debug("===VVD 변경===" + edi_snd_id);
    				    list1.add(sceEdi324SndRslt);
    		  	}
    	  }
          log.debug("==== 같은 VVD 정보 갯수 : === "+ list1.size());
          //VVD 값을 발송 flast 파일에 설정을 한다.
		  for (int m = 0 ; m < list1.size() ; m++){
			   main = 
      			   "VVD:"                    + list1.get(m).getVslCd() + list1.get(m).getSkdVoyNo() + list1.get(m).getSkdDirCd() + CHR10
      			   +   "VSL_LLOYDCODE:"      + list1.get(m).getLloydVslNo()                                           									 + CHR10
      			   +   "VSL_FULLNAME:"       + list1.get(m).getVslNm()                                          											 + CHR10
      			   +   "POD_YD:"             + list1.get(m).getPodYdCd()          + CHR10
      			   +   "POD_NAME:"           + list1.get(m).getPodNm()                                      + CHR10
      			   +   "POD_ETA:"            + list1.get(m).getPodEstmArrDt()                                          + CHR10;
      		    log.debug("file main"+m+"==" + main.toString());
      		    for (int j = 0 ; j <sceEdi324SndrsltVo.size() ; j++ ){
             	  if (list1.get(m).getVslCd().equals(sceEdi324SndrsltVo.get(j).getVslCd()) 
             		  && list1.get(m).getSkdVoyNo().equals(sceEdi324SndrsltVo.get(j).getSkdVoyNo()) 
             		  && list1.get(m).getSkdDirCd().equals(sceEdi324SndrsltVo.get(j).getSkdDirCd())){
             		  
					  cntr_info = cntr_info + "{CNTR_INFO " +  CHR10
					    + "CNTRNBR:"     	  + sceEdi324SndrsltVo.get(j).getCntrNo()     		+ CHR10
						+ "BLNBR:"     		  + sceEdi324SndrsltVo.get(j).getBlNo()  			+ CHR10
						+ "CNTRWGT:"     	  + sceEdi324SndrsltVo.get(j).getCntrWgt()  		+ CHR10
						+ "CNTRWGT_UNIT:"     + sceEdi324SndrsltVo.get(j).getCntrWgtUtCd()  	+ CHR10
						+ "CNTRWGT_LB:"       + sceEdi324SndrsltVo.get(j).getCntrLbsWgt()  		+ CHR10
						+ "CNTRTS:"      	  + sceEdi324SndrsltVo.get(j).getCntrTpszCd()  		+ CHR10
						+ "CNTRL:"      	  + sceEdi324SndrsltVo.get(j).getCntrLen()  		+ CHR10
						+ "CNTRH:"      	  + sceEdi324SndrsltVo.get(j).getCntrHgt()  		+ CHR10
						+ "SEALNBR:"      	  + sceEdi324SndrsltVo.get(j).getCntrSealNo()    	+ CHR10
						+ "ORGCTY:"      	  + sceEdi324SndrsltVo.get(j).getOrgYdLocCtyNm()    + CHR10
						+ "ORGSTATE:"      	  + sceEdi324SndrsltVo.get(j).getOrgYdLocSteCd()    + CHR10
						+ "ORGLOC:"      	  + sceEdi324SndrsltVo.get(j).getOrgLocNm()     	+ CHR10
						+ "ORGYD:"      	  + sceEdi324SndrsltVo.get(j).getOrgYdCd()  		+ CHR10
						+ "DSTCTY:"      	  + sceEdi324SndrsltVo.get(j).getDestYdLocCtyNm()  	+ CHR10
						+ "DSTSTATE:"      	  + sceEdi324SndrsltVo.get(j).getDestYdLocSteCd()  	+ CHR10
						+ "DSTLOC:"      	  + sceEdi324SndrsltVo.get(j).getDestLocNm()  		+ CHR10
						+ "DSTYD:"      	  + sceEdi324SndrsltVo.get(j).getDestYdCd() 		+ CHR10
						+ "DG_IND:"      	  + sceEdi324SndrsltVo.get(j).getDgFlg()    		+ CHR10
						+ "}CNTR_INFO"        + CHR10;
	                  log.debug("flat cnrt info " + sceEdi324SndrsltVo.get(j).getOrgYdLocSteCd());
				  
				  }
             	
		  		}
      		    
				HashMap<String, String> valuesOfFFKey = getSNDSEQ();
				String ff_ymmdd  = valuesOfFFKey.get("FF_YMMDD");
				String ff_seq    = valuesOfFFKey.get("FF_SEQ");
				
				cust_trd_prnr_id = "";
				cust_trd_prnr_id = dbDao.searchEdi324PrnrId( list1.get(m).getVndrSeq());
				
				flt_file_ref_no = "";
				flt_file_ref_no = "SCM" + ff_ymmdd + lpad(ff_seq, 6, "0");
          	 
                log.debug("flat file info "+ main.toString() + cntr_info + "flt_file_ref_no: "+ flt_file_ref_no );
                sendProcess(main , cntr_info, flt_file_ref_no, cust_trd_prnr_id); 
                dbDao.modifySceEdi324SndRslt(list1.get(m) ,list1.get(m).getEdiSndId(), flt_file_ref_no);
                cntr_info="";
		  }
     		//보내고 난뒤에  발송된 정보의 상태값을 변경을한다. 
//		  for (int m= 0 ; m < list1.size() ; m++){
//			  
//			  for (int nm =0 ; nm < sceEdi324SndrsltVo.size() ; nm++){
//				
//				  if (list1.get(m).getVslCd().equals(sceEdi324SndrsltVo.get(nm).getVslCd()) && 
//				      list1.get(m).getSkdVoyNo().equals(sceEdi324SndrsltVo.get(nm).getSkdVoyNo()) && 
//				      list1.get(m).getSkdDirCd().equals(sceEdi324SndrsltVo.get(nm).getSkdDirCd())){
//					  edi_snd_id = list1.get(m).getEdiSndId();
//					  log.debug("===edi_snd_id====" + edi_snd_id);
//				      dbDao.modifySceEdi324SndRslt(sceEdi324SndrsltVo.get(nm) ,edi_snd_id);
//				  }
//			  }
//		  }
		 
      	}
	  } catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage());
	  }
	  
      return result;
    }
    /**
	 * sendProcess 
	 * MQ발송과 Logging Process.
	 * 
	 * @param String mainString
	 * @param String cntr_infoString
	 * @exception EventException
	 */
    private void sendProcess(String mainString ,String cntr_infoString, String fltFileRefNo, String custTrdPrnrId) throws EventException {
		String ediString ="";
		try {
			String headerStr = "$$$MSGSTART:"
				+ rpad("SMLINE", 20, "  ")
				+ rpad(custTrdPrnrId, 20, "  ")
				+ rpad("324", 10, "  ") + fltFileRefNo + CHR10 ;
//			String headerStr = "$$$MSGSTART:"
//					+ "SMLINE"	+ CHR10					;
			ediString = headerStr + mainString + cntr_infoString;
			log.debug("========발송 파일 정보 ======" + ediString);
			sendEDIMQ(ediString);
			log.debug("========sendEDIMQ _OK======");
			
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage());
		}

	}
	

    /**
	 * sendEDIMQ
	 * Edi324SendEAIDAO 를 통해서 MQ 발송을 한다. 
     * @param     String ediString
     * @exception EventException
     */     
    public void sendEDIMQ(String ediString)throws EventException{
    	Edi324SendEAIDAO edi324SendEaiDao = null;
    	try {
    		
    		edi324SendEaiDao = new Edi324SendEAIDAO();
		    edi324SendEaiDao.sendEDIMQ(ediString);
			log.debug("\n sendEDIMQ's send _OK");
			
    	} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
  
    }
    
    /**
     * 오라클데이터베이스로 부터 특정 시퀀스넘버를 받아옴 <br>
     * 
     * @return HashMap<String,String>
     * @throws EventException
     */		
    private HashMap<String,String> getSNDSEQ() throws EventException{
		try {
			HashMap<String,String> keys_values = new HashMap<String,String>();
			DBRowSet rowset = dbDao.getSndSeq();
			if (rowset != null && rowset.next()) {
				keys_values.put("FF_YYMMDD", rowset.getString("FF_YYMMDD"));
				keys_values.put("FF_YMMDD" , rowset.getString("FF_YMMDD" ));
				keys_values.put("FF_SEQ"   , rowset.getString("FF_SEQ"   ));
			}else{
				log.error("\n 324Error : 324SendDBDAOGetSndSeqRSQL IS NULL <-- FF No Creation Method");
			}
			   return keys_values;
		} catch (DAOException e) {
			throw new EventException(e.getMessage(),e);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}
	/**rpad -  오라클의 함수 rpad 와 비슷한 역활을 하는 함수  
     * @param  String oStr
     * @param  int len
     * @param  String padding
     * @return String
     */       
    private String rpad(String oStr,int len,String padding){
    	StringBuffer strBuff = null;
    	if(oStr != null){
    		if(oStr.length() > len){
    			        return oStr; 
    		}else{
		    			
		    			for(int i=0;i<len;i++){
		    				strBuff = new StringBuffer(oStr);
		    				strBuff.append(padding);
		    				oStr = strBuff.toString();
		    				if(oStr.length() == len) break;
		    				else if(oStr.length() > len) oStr = oStr.substring(0, len);
		    				else continue;
		    			}
		    			return oStr;
    		}
    	}
    	return "";
    }  
    
	/**lpad -  오라클의 함수 lpad 와 비슷한 역활을 하는 함수  
     * @param  String oStr
     * @param  int len
     * @param  String padding
     * @return String
     */ 
    private String lpad(String oStr,int len,String padding){
    	StringBuffer strBuff = null;
        if(oStr != null){
        	if(oStr.length() == len){
        		return oStr;
        	}else if(oStr.length() > len){
        		return oStr.substring(0,len);
        	}else{
        		  int diff = len - oStr.length();
        		  strBuff = new StringBuffer();
        		  for(int m=0;m<diff;m++){
        			  strBuff.append(padding);
        		  }
        		  strBuff.append(oStr);
        		  return strBuff.toString();
        	}
        }
    	return "";
    }      
	
}