/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : ScheduleReceiveManagementDBDAOSelectExchangeHeaderRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.04.05
*@LastModifier : 
*@LastVersion : 1.0
* 2014.04.05 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.vsk.scheduleexchangemanagement.schedulereceivemanagement.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ScheduleReceiveManagementDBDAOSelectExchangeHeaderRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Exchange 대상데이터 조회
	  * </pre>
	  */
	public ScheduleReceiveManagementDBDAOSelectExchangeHeaderRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("skd_edi_rcv_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.vop.vsk.scheduleexchangemanagement.schedulereceivemanagement.integration").append("\n"); 
		query.append("FileName : ScheduleReceiveManagementDBDAOSelectExchangeHeaderRSQL").append("\n"); 
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
		query.append("SELECT  X.SND_RCV_KND_CD     " ).append("\n"); 
		query.append("    ,  	X.SKD_EDI_RCV_DT     " ).append("\n"); 
		query.append("    ,  	X.SKD_EDI_RCV_SEQ    " ).append("\n"); 
		query.append("    ,  	X.VSL_CD_CTNT        " ).append("\n"); 
		query.append("    ,  	X.SKD_VOY_NO_CTNT    " ).append("\n"); 
		query.append("    ,  	X.SKD_DIR_CD_CTNT    " ).append("\n"); 
		query.append("    ,  	X.EDI_HDR_MSG        " ).append("\n"); 
		query.append("    ,  	X.EDI_FUNC_CD_CTNT   " ).append("\n"); 
		query.append("    ,  	X.CO_CD_CTNT         " ).append("\n"); 
		query.append("    ,  	X.VSL_SLAN_CD_CTNT   " ).append("\n"); 
		query.append("    ,  	X.SKD_CNG_STS_CD_CTNT" ).append("\n"); 
		query.append("    ,  	X.ARR_DEP_IND_CD_CTNT" ).append("\n"); 
		query.append("    ,  	X.CALL_SGN_NO        " ).append("\n"); 
		query.append("    ,  	X.LLOYD_NO           " ).append("\n"); 
		query.append("    ,  	X.SHP_CALL_NO        " ).append("\n"); 
		query.append("    ,  	X.VSL_ENG_NM         " ).append("\n"); 
		query.append("    ,  	X.PIC_NM             " ).append("\n"); 
		query.append("    ,  	X.PIC_CNTC_TP_CD     " ).append("\n"); 
		query.append("    ,  	X.PIC_CNTC_NO        " ).append("\n"); 
		query.append("    ,  	X.EDI_RMK            " ).append("\n"); 
		query.append("    ,  	X.MAPG_SCS_FLG       " ).append("\n"); 
		query.append("    ,  	X.EDI_PROC_RMK       " ).append("\n"); 
		query.append("    ,  	X.CRE_USR_ID         " ).append("\n"); 
		query.append("    ,  	X.CRE_DT             " ).append("\n"); 
		query.append("    ,  	X.UPD_USR_ID         " ).append("\n"); 
		query.append("    ,  	X.UPD_DT  " ).append("\n"); 
		query.append("FROM    VSK_VSL_SKD_XCH_EDI_HDR  	X" ).append("\n"); 
		query.append("WHERE   1 = 1" ).append("\n"); 
		query.append("AND     X.SND_RCV_KND_CD        	= 'R'" ).append("\n"); 
		query.append("AND     X.SKD_EDI_RCV_SEQ       	= @[skd_edi_rcv_seq]" ).append("\n"); 

	}
}