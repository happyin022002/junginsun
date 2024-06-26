/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : MalaysiaCustomsTransmissionDBDAOSearchCntrSealNoInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.08.28
*@LastModifier : 
*@LastVersion : 1.0
* 2017.08.28 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.malaysia.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class MalaysiaCustomsTransmissionDBDAOSearchCntrSealNoInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 2012.02.02 변종건 [CHM-201215473-01] Malaysis (MYTPP) Customs Manifest 전송 기능 추가 요청
	  * </pre>
	  */
	public MalaysiaCustomsTransmissionDBDAOSearchCntrSealNoInfoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.malaysia.integration").append("\n"); 
		query.append("FileName : MalaysiaCustomsTransmissionDBDAOSearchCntrSealNoInfoRSQL").append("\n"); 
		query.append("*/").append("\n"); 
	}
	
	public String getSQL(){
		return query.toString();
	}
	
	public HashMap<String,String[]> getParams() {
		return params;
	}

	/**
	 * Query 생성
	 */
	public void setQuery(){
		query.append("SELECT    TRIM(SUBSTR(CNTR_SEAL_NO,1,10)) SEALNBR" ).append("\n"); 
		query.append("     ,    NVL(SEAL_PTY_TP_CD,'')          SEAL_PTY_TP_CD" ).append("\n"); 
		query.append("FROM      BKG_CNTR_SEAL_NO" ).append("\n"); 
		query.append("WHERE     BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("AND       CNTR_NO = @[cntr_no]" ).append("\n"); 
		query.append("AND       CNTR_SEAL_SEQ > 0 " ).append("\n"); 

	}
}