/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : WeeklyCMDBDAOStorageCalExcepNodeRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.09.01
*@LastModifier : 최덕우
*@LastVersion : 1.0
* 2015.09.01 최덕우
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.mas.weeklypfmc.weeklycm.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Choi Duk Woo
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class WeeklyCMDBDAOStorageCalExcepNodeRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Storage Calculation Exception Node 를 조회한다.
	  * </pre>
	  */
	public WeeklyCMDBDAOStorageCalExcepNodeRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tmp_f_ctrl_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_nod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_nod_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_rdodelflg",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.mas.weeklypfmc.weeklycm.integration").append("\n"); 
		query.append("FileName : WeeklyCMDBDAOStorageCalExcepNodeRSQL").append("\n"); 
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
		query.append("SELECT  N.NOD_CD" ).append("\n"); 
		query.append("	   ,(SELECT YD_NM FROM MDM_YARD M WHERE M.YD_CD = N.NOD_CD) NOD_NM" ).append("\n"); 
		query.append("	   ,N.CTRL_OFC_CD" ).append("\n"); 
		query.append("	   ,N.OB_STO_FLG" ).append("\n"); 
		query.append("	   ,DECODE(N.OB_STO_NOD_TP_CD, 'M','MAT','R','RR','ALL') OB_NOD_TP" ).append("\n"); 
		query.append("	   ,N.IB_STO_FLG" ).append("\n"); 
		query.append("	   ,DECODE(N.IB_STO_NOD_TP_CD, 'M','MAT','R','RR','ALL') IB_NOD_TP" ).append("\n"); 
		query.append("	   ,N.EXP_CUST_CD_CTNT EXP_CUST_CD" ).append("\n"); 
		query.append("	   ,N.STO_EXP_NOD_RMK RMK" ).append("\n"); 
		query.append("	   ,N.MAS_UC_FLG" ).append("\n"); 
		query.append("       ,N.DELT_FLG" ).append("\n"); 
		query.append("	   ,N.UPD_DT AS UPD_DT_ORDER" ).append("\n"); 
		query.append("       ,TO_CHAR(N.CRE_DT,'YYYY-MM-DD') AS CRE_DT" ).append("\n"); 
		query.append("	   ,TO_CHAR(N.UPD_DT,'YYYY-MM-DD') AS UPD_DT      " ).append("\n"); 
		query.append("       ,N.NOD_CD AS NOD_CD_ORG" ).append("\n"); 
		query.append("       ,N.CTRL_OFC_CD AS CTRL_OFC_CD_ORG" ).append("\n"); 
		query.append("       ,N.OB_STO_FLG AS OB_STO_FLG_ORG" ).append("\n"); 
		query.append("       ,N.IB_STO_FLG AS IB_STO_FLG_ORG" ).append("\n"); 
		query.append("FROM MAS_STO_EXP_NOD N" ).append("\n"); 
		query.append("	,MDM_YARD M" ).append("\n"); 
		query.append("WHERE 1=1  " ).append("\n"); 
		query.append("  AND N.NOD_CD = M.YD_CD(+)" ).append("\n"); 
		query.append("#if (${f_nod_cd} != '')" ).append("\n"); 
		query.append("  AND N.NOD_CD LIKE @[f_nod_cd]||'%'  " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${f_nod_nm} != '')" ).append("\n"); 
		query.append("  AND N.NOD_CD IN (SELECT YD_CD FROM MDM_YARD M WHERE M.YD_NM LIKE @[f_nod_nm]||'%')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${f_ctrl_ofc_cd} != '')" ).append("\n"); 
		query.append("  AND N.CTRL_OFC_CD IN (SELECT OFC_CD FROM MDM_ORGANIZATION WHERE DELT_FLG = 'N' CONNECT BY NOCYCLE PRIOR OFC_CD = PRNT_OFC_CD START WITH OFC_CD = @[tmp_f_ctrl_ofc_cd])" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${f_rdodelflg} != '')" ).append("\n"); 
		query.append("  AND N.DELT_FLG = @[f_rdodelflg]" ).append("\n"); 
		query.append("#end " ).append("\n"); 
		query.append("ORDER BY N.NOD_CD" ).append("\n"); 

	}
}