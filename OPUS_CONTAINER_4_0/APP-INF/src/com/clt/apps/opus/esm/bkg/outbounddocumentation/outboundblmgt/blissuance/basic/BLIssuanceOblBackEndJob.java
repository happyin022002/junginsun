/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : BLIssuanceOblBackEndJob.java
*@FileTitle : BLIssuanceOblBackEndJob
*Open Issues :
*Change history :
*@LastModifyDate : 2016.05.31
*@LastModifier : 
*@LastVersion : 1.0
* 2016.05.31
* 1.0 Creation
* ======================================================================
* History
=========================================================*/
package com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.basic;


import com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.basic.BookingUtil;
import com.clt.framework.core.config.SubSystemConfigFactory;
import com.clt.framework.support.layer.backend.BackEndCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;
import com.clt.framework.table.ComUpldFileVO;

/**
 * Original B/L download 대한 비지니스 트랜잭션을 처리한다.
 * 
 * @author 
 * @see BLIssuanceDBDAO
 * @since J2EE 1.6
 */
public class BLIssuanceOblBackEndJob extends BackEndCommandSupport {

	private static final long serialVersionUID = -1149789439988228547L;

	private String fileKey;
	

	/**
	 * BLIssuanceOblBackEndJob 생성자<br>
	 * @param String fileKey
	 * @throws Exception
	 */
	public BLIssuanceOblBackEndJob(String fileKey) throws Exception {
		this.fileKey = fileKey;
		
	}

	/**
	 * Original B/L download<br>
     * 
	 * @return GeneralEventResponse
	 * @exception Exception
	 */
	public String doStart() throws Exception {
		BookingUtil util = new BookingUtil();
		// call file
		ComUpldFileVO fileInfo = new ComUpldFileVO();
		
		boolean fileCk = true;
		int loopCount = 1;
		
		if(fileKey==null||fileKey.equals(""))		return "N";
		
		do {
			Thread.sleep(2000);		//2 sec * 870 = 29 min (js 셋팅 30분)
			try{
				fileInfo = util.comUpldFileInfo(fileKey);
				if(loopCount > 870) {
					return "N";
				}
			}catch(Exception exc){
				log.error(exc.getMessage());
//				return "N";
				throw exc;
			}
			if(fileInfo != null && fileInfo.getFileSavId()!=null && !fileInfo.getFileSavId().trim().equals("")){
				return "Y";
			}
			
			log.debug("fileKey = " + fileKey);
				   
			log.debug("loopCount = " + loopCount);
			loopCount = loopCount + 1;
		} while (fileCk);
		
		return "Y";		
	}


}
