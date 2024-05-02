/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : RocsCustomsTransmissionDBDAOsearchCntrInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.01.22
*@LastModifier : 
*@LastVersion : 1.0
* 2010.01.22 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.rocs.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class RocsCustomsTransmissionDBDAOsearchCntrInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ROCS(ROTTERDAM) 세관 신고용
	  * </pre>
	  */
	public RocsCustomsTransmissionDBDAOsearchCntrInfoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("frm_crn_number",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.rocs.integration").append("\n"); 
		query.append("FileName : RocsCustomsTransmissionDBDAOsearchCntrInfoRSQL").append("\n"); 
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
		query.append("SELECT A.CNTR_NO," ).append("\n"); 
		query.append("A.ISO_CNTR_TPSZ_CD CNTR_TS," ).append("\n"); 
		query.append("RTRIM(LTRIM(A.CNTR_SEAL_NO)) SEAL_NO," ).append("\n"); 
		query.append("DECODE(B.LSTM_CD,'SH','1','2') CNTR_SC," ).append("\n"); 
		query.append("DECODE(L.BKG_CGO_TP_CD,'P','M',L.BKG_CGO_TP_CD) CNTR_FM" ).append("\n"); 
		query.append("FROM   BKG_CSTMS_RTM_CNTR A, MST_CONTAINER B, BKG_CSTMS_RTM_BL L" ).append("\n"); 
		query.append("WHERE  A.VSL_CALL_REF_NO = @[frm_crn_number]" ).append("\n"); 
		query.append("AND    A.BKG_NO 		= @[bkg_no]" ).append("\n"); 
		query.append("AND    A.CNTR_NO 		= B.CNTR_NO" ).append("\n"); 
		query.append("AND    A.VSL_CALL_REF_NO 	= L.VSL_CALL_REF_NO" ).append("\n"); 
		query.append("AND    A.BKG_NO 		= L.BKG_NO" ).append("\n"); 

	}
}