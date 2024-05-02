/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : CIMCommonDBDAOCntrMvmtInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.08.31
*@LastModifier : 
*@LastVersion : 1.0
* 2015.08.31 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.cim.cimcommon.cimcommon.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CIMCommonDBDAOCntrMvmtInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * CntrMvmtInfo Select
	  * </pre>
	  */
	public CIMCommonDBDAOCntrMvmtInfoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mvmt_edi_msg_yrmondy",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mvmt_edi_msg_area_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mvmt_edi_msg_tp_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mvmt_edi_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mvmt_edi_msg_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.cim.cimcommon.cimcommon.integration").append("\n"); 
		query.append("FileName : CIMCommonDBDAOCntrMvmtInfoRSQL").append("\n"); 
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
		query.append("SELECT " ).append("\n"); 
		query.append("	(SELECT NVL(CNMV_STS_CD,'') FROM BKG_CONTAINER BC WHERE BC.CNTR_NO=CM.CNTR_NO AND BC.BKG_NO=CM.BKG_NO AND ROWNUM=1) AS PREV_STS_CD," ).append("\n"); 
		query.append("	IMDT_EXT_FLG," ).append("\n"); 
		query.append("	CNMV_YR," ).append("\n"); 
		query.append("	CNMV_ID_NO," ).append("\n"); 
		query.append("	CNMV_SEQ," ).append("\n"); 
		query.append("	CNMV_SPLIT_NO," ).append("\n"); 
		query.append("	SYS_AREA_GRP_ID AS CNTR_SVR_ID	" ).append("\n"); 
		query.append("FROM CTM_MOVEMENT CM" ).append("\n"); 
		query.append("WHERE  CM.MVMT_EDI_MSG_AREA_CD   = @[mvmt_edi_msg_area_cd]" ).append("\n"); 
		query.append("	AND CM.MVMT_EDI_MSG_SEQ      = @[mvmt_edi_msg_seq]" ).append("\n"); 
		query.append("	AND CM.MVMT_EDI_MSG_TP_ID    = @[mvmt_edi_msg_tp_id]" ).append("\n"); 
		query.append("	AND CM.MVMT_EDI_MSG_YRMONDY  = @[mvmt_edi_msg_yrmondy]" ).append("\n"); 
		query.append("	AND CM.MVMT_EDI_TP_CD        = @[mvmt_edi_tp_cd]" ).append("\n"); 

	}
}