/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : LeaseSubleaseDBDAOMstContainerVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.01.18
*@LastModifier : 
*@LastVersion : 1.0
* 2017.01.18 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.mst.equipmentleasehistory.leasesublease.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class LeaseSubleaseDBDAOMstContainerVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Container Status Inquiry
	  * </pre>
	  */
	public LeaseSubleaseDBDAOMstContainerVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("chk_dgt",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.mst.equipmentleasehistory.leasesublease.integration").append("\n"); 
		query.append("FileName : LeaseSubleaseDBDAOMstContainerVORSQL").append("\n"); 
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
		query.append("       A.CNTR_NO,   " ).append("\n"); 
		query.append("       SUBSTR(A.CNTR_NO,11) CHK_DGT, " ).append("\n"); 
		query.append("       DECODE(A.ACIAC_DIV_CD, 'I', 'Inactive','A','Active') ACIAC_DIV_CD, " ).append("\n"); 
		query.append("       A.CNTR_TPSZ_CD," ).append("\n"); 
		query.append("       A.LSTM_CD, " ).append("\n"); 
		query.append("       B.CNTR_TPSZ_ISO_CD, " ).append("\n"); 
		query.append("       DECODE(C.CNTR_OLD_VAN_FLG,'Y', 'Old', 'New') CNTR_OLD_VAN_FLG," ).append("\n"); 
		query.append("       D.OWNR_CO_CD," ).append("\n"); 
		query.append("       F.CNTR_USE_CO_CD," ).append("\n"); 
		query.append("	   CASE WHEN A.ACIAC_DIV_CD = 'A' THEN" ).append("\n"); 
		query.append("            --Active 상태인데, MNR/Sold('Y') 가 있다는 의미는 Manual Sold Cancel를 했다는 의미" ).append("\n"); 
		query.append("            NVL (" ).append("\n"); 
		query.append("                (" ).append("\n"); 
		query.append("                SELECT  'Y'" ).append("\n"); 
		query.append("                FROM    MNR_DISP_HDR    T1," ).append("\n"); 
		query.append("                        MNR_DISP_DTL    T2" ).append("\n"); 
		query.append("                WHERE   T1.DISP_NO  = T2.DISP_NO" ).append("\n"); 
		query.append("                AND     T2.EQ_NO    = A.CNTR_NO                " ).append("\n"); 
		query.append("                AND     T1.DISP_STS_CD <> 'HD'" ).append("\n"); 
		query.append("                AND     T2.DISP_SOLD_DT IS NOT NULL" ).append("\n"); 
		query.append("                ), 'N')" ).append("\n"); 
		query.append("       ELSE" ).append("\n"); 
		query.append("            'N'" ).append("\n"); 
		query.append("       END      AS MNR_SLD_CHK" ).append("\n"); 
		query.append("FROM MST_CONTAINER A, " ).append("\n"); 
		query.append("     MDM_CNTR_TP_SZ B," ).append("\n"); 
		query.append("     MST_CNTR_STS_HIS C," ).append("\n"); 
		query.append("     (SELECT DECODE(INTG_CD_VAL_CTNT,'H','SM Line',INTG_CD_VAL_DP_DESC) OWNR_CO_CD, INTG_CD_VAL_CTNT" ).append("\n"); 
		query.append("      FROM COM_INTG_CD_DTL" ).append("\n"); 
		query.append("      WHERE INTG_CD_ID ='CD01047') D," ).append("\n"); 
		query.append("     (SELECT DECODE(INTG_CD_VAL_CTNT,'H','SM Line',INTG_CD_VAL_DP_DESC) CNTR_USE_CO_CD, INTG_CD_VAL_CTNT" ).append("\n"); 
		query.append("      FROM COM_INTG_CD_DTL" ).append("\n"); 
		query.append("      WHERE INTG_CD_ID ='CD01020') F" ).append("\n"); 
		query.append("WHERE 1 = 1" ).append("\n"); 
		query.append(" #if(${noExit} == 'A')" ).append("\n"); 
		query.append("        #if (${chk_dgt} == '')" ).append("\n"); 
		query.append("        AND  A.CNTR_NO = @[cntr_no]" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("        #if (${chk_dgt} != '') " ).append("\n"); 
		query.append("        AND  A.CNTR_NO = @[cntr_no] || @[chk_dgt]" ).append("\n"); 
		query.append("        #end " ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("    #if(${noExit} == 'E')" ).append("\n"); 
		query.append("        #if (${chk_dgt} == '')" ).append("\n"); 
		query.append("        AND  A.CNTR_NO = MST_COMMON_PKG.MST_CNTR_NO_FNC(@[cntr_no])" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("        #if (${chk_dgt} != '') " ).append("\n"); 
		query.append("        AND  A.CNTR_NO = @[cntr_no] || @[chk_dgt]" ).append("\n"); 
		query.append("        #end " ).append("\n"); 
		query.append("    #end        " ).append("\n"); 
		query.append("AND B.CNTR_TPSZ_CD = A.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("AND C.CNTR_NO(+) = A.CNTR_NO" ).append("\n"); 
		query.append("AND D.INTG_CD_VAL_CTNT(+) = A.OWNR_CO_CD" ).append("\n"); 
		query.append("AND F.INTG_CD_VAL_CTNT(+) = A.CNTR_USE_CO_CD" ).append("\n"); 
		query.append("AND ROWNUM = 1" ).append("\n"); 

	}
}