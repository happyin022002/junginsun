/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : UsaInbondTransmissionDBDAOUsaMibTransmitVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.04.28
*@LastModifier : 
*@LastVersion : 1.0
* 2010.04.28 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.inbondtransmission.usa.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class UsaInbondTransmissionDBDAOUsaMibTransmitVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * UsaMibTransmitVO 생성을 위해사용
	  * MibTransmitVO를 상속받는다.
	  * </pre>
	  */
	public UsaInbondTransmissionDBDAOUsaMibTransmitVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.inbondtransmission.usa.integration").append("\n"); 
		query.append("FileName : UsaInbondTransmissionDBDAOUsaMibTransmitVORSQL").append("\n"); 
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
		query.append("SELECT" ).append("\n"); 
		query.append("''USA_LST_LOC_CD" ).append("\n"); 
		query.append(",''XPT_FLG" ).append("\n"); 
		query.append(",''ARR_DT" ).append("\n"); 
		query.append(",''TRSP_ISS_DT" ).append("\n"); 
		query.append(",''BL_NO" ).append("\n"); 
		query.append(",''TRSP_ISS_TIME" ).append("\n"); 
		query.append(",''XPT_ACPT_DT" ).append("\n"); 
		query.append(",''CNMV_STS_CD" ).append("\n"); 
		query.append(",''FRT_CLT_FLG" ).append("\n"); 
		query.append(",''BL_CNTR_FLAG" ).append("\n"); 
		query.append(",''MJR_IBD_AUTH_DT" ).append("\n"); 
		query.append(",''ARR_TIME" ).append("\n"); 
		query.append(",''XPT_DT" ).append("\n"); 
		query.append(",''IBD_TRSP_NO" ).append("\n"); 
		query.append(",''CSTMS_CLR_CD" ).append("\n"); 
		query.append(",''MJR_IBD_AUTH_TIME" ).append("\n"); 
		query.append(",''DEL_CD" ).append("\n"); 
		query.append(",''OBL_RDEM_FLG" ).append("\n"); 
		query.append(",''ARR_FLG" ).append("\n"); 
		query.append(",''IBD_TP_CD" ).append("\n"); 
		query.append(",''VVD" ).append("\n"); 
		query.append(",''POD_CD" ).append("\n"); 
		query.append(",''AVAL_DT" ).append("\n"); 
		query.append(",''YD_CD" ).append("\n"); 
		query.append(",''CNTR_NO" ).append("\n"); 
		query.append(",''TRSP_AUTH_DT" ).append("\n"); 
		query.append(",''XPT_ACPT_TIME" ).append("\n"); 
		query.append(",''TRSP_AUTH_TIME" ).append("\n"); 
		query.append(",''XPT_TIME" ).append("\n"); 
		query.append(",''HUB_LOC_CD" ).append("\n"); 
		query.append(",''PKUP_NO" ).append("\n"); 
		query.append(",''CSTMS_POD_CD" ).append("\n"); 
		query.append(",''USR_ID" ).append("\n"); 
		query.append(",''OFC_CD" ).append("\n"); 
		query.append(",''TRANS_GUBUN" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 

	}
}