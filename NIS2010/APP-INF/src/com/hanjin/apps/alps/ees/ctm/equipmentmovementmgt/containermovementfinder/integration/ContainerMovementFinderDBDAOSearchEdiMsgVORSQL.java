/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : ContainerMovementFinderDBDAOSearchEdiMsgVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.05
*@LastModifier : 김상수
*@LastVersion : 1.0
* 2010.03.05 김상수
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.ctm.equipmentmovementmgt.containermovementfinder.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author KIM, Sang Soo
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ContainerMovementFinderDBDAOSearchEdiMsgVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * EES_CTM_0408 : 컨테이너 번호에 의한 EDI Message List 조회   
	  * </pre>
	  */
	public ContainerMovementFinderDBDAOSearchEdiMsgVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("edi_date",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("check_digit",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("p_cntrno",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.ctm.equipmentmovementmgt.containermovementfinder.integration").append("\n"); 
		query.append("FileName : ContainerMovementFinderDBDAOSearchEdiMsgVORSQL").append("\n"); 
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
		query.append("SELECT   /*+ INDEX (CTM_MVMT_EDI_MSG XAK2CTM_MVMT_EDI_MSG) */" ).append("\n"); 
		query.append("EVNT_YD_CD," ).append("\n"); 
		query.append("TO_CHAR (EVNT_DT, 'YYYY-MM-DD HH24:MI') AS EVNT_DT," ).append("\n"); 
		query.append("TO_CHAR (CRE_LOCL_DT, 'YYYY-MM-DD HH24:MI') AS CRE_LOCL_DT," ).append("\n"); 
		query.append("BKG_NO," ).append("\n"); 
		query.append("EDI_BL_NO AS BL_NO," ).append("\n"); 
		query.append("CRNT_VSL_CD," ).append("\n"); 
		query.append("CRNT_SKD_VOY_NO," ).append("\n"); 
		query.append("CRNT_SKD_DIR_CD," ).append("\n"); 
		query.append("EDI_MVMT_STS_CD," ).append("\n"); 
		query.append("EDI_GATE_IO_CD," ).append("\n"); 
		query.append("CNTR_FULL_STS_CD," ).append("\n"); 
		query.append("MVMT_EDI_SGHT_CD," ).append("\n"); 
		query.append("MVMT_EDI_RMK" ).append("\n"); 
		query.append("FROM CTM_MVMT_EDI_MSG" ).append("\n"); 
		query.append("WHERE CNTR_NO = @[p_cntrno]||@[check_digit]" ).append("\n"); 
		query.append("#if (${edi_date} != '')" ).append("\n"); 
		query.append("AND EVNT_DT > TO_DATE (@[edi_date], 'YYYY-MM-DD HH24:MI')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("AND MVMT_EDI_RSLT_CD = 'N'" ).append("\n"); 
		query.append("ORDER BY EVNT_DT" ).append("\n"); 

	}
}