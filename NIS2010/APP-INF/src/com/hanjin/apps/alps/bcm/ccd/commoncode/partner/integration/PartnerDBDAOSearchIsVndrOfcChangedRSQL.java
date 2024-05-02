/*=========================================================
*Copyright(c) 2018 SM Line
*@FileName : PartnerDBDAOSearchIsVndrOfcChangedRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2018.04.02
*@LastModifier : 
*@LastVersion : 1.0
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.bcm.ccd.commoncode.partner.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PartnerDBDAOSearchIsVndrOfcChangedRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * MDM_VENDOR의 OFC_CD의 변경 여부를 확인한다.
	  * </pre>
	  */
	public PartnerDBDAOSearchIsVndrOfcChangedRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vndr_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.bcm.ccd.commoncode.partner.integration").append("\n"); 
		query.append("FileName : PartnerDBDAOSearchIsVndrOfcChangedRSQL").append("\n"); 
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
		query.append("SELECT VNDR_SEQ " ).append("\n"); 
		query.append("      ,NVL(VNDR_CNT_CD_NEW, 'XX') VNDR_CNT_CD_NEW" ).append("\n"); 
		query.append("      ,SAKURA_VNDR_CNT_CD" ).append("\n"); 
		query.append("      ,OFC_CD_NEW" ).append("\n"); 
		query.append("      ,OFC_CD" ).append("\n"); 
		query.append("      ,CASE WHEN NVL(VNDR_CNT_CD_NEW, 'XX') = SAKURA_VNDR_CNT_CD THEN 'N'" ).append("\n"); 
		query.append("            ELSE 'Y'" ).append("\n"); 
		query.append("        END IS_CHANGED" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("      SELECT VIF.VNDR_SEQ" ).append("\n"); 
		query.append("            ,VIF.VNDR_CNT_CD" ).append("\n"); 
		query.append("            ,(SELECT CNT_CD" ).append("\n"); 
		query.append("                FROM MDM_LOCATION" ).append("\n"); 
		query.append("               WHERE LOC_CD = (SELECT LOC_CD " ).append("\n"); 
		query.append("                                 FROM MDM_ORGANIZATION ORG" ).append("\n"); 
		query.append("                                WHERE ORG.OFC_CD = @[ofc_cd])" ).append("\n"); 
		query.append("             ) VNDR_CNT_CD_NEW " ).append("\n"); 
		query.append("            ,(SELECT CNT_CD" ).append("\n"); 
		query.append("                FROM MDM_LOCATION" ).append("\n"); 
		query.append("               WHERE LOC_CD = (SELECT LOC_CD " ).append("\n"); 
		query.append("                                 FROM MDM_ORGANIZATION ORG" ).append("\n"); 
		query.append("                                WHERE ORG.OFC_CD = VIF.OFC_CD)" ).append("\n"); 
		query.append("             ) SAKURA_VNDR_CNT_CD" ).append("\n"); 
		query.append("            ,@[ofc_cd] OFC_CD_NEW" ).append("\n"); 
		query.append("            ,VIF.OFC_CD" ).append("\n"); 
		query.append("            ,VIF.UPD_DT" ).append("\n"); 
		query.append("            ,VIF.DELT_FLG" ).append("\n"); 
		query.append("            ,ROW_NUMBER() OVER(PARTITION BY VIF.VNDR_SEQ ORDER BY VIF.VNDR_SEQ, VIF.UPD_DT DESC) R" ).append("\n"); 
		query.append("        FROM MDM_VENDOR VIF" ).append("\n"); 
		query.append("       WHERE VIF.VNDR_SEQ = @[vndr_seq]" ).append("\n"); 
		query.append("     )" ).append("\n"); 
		query.append("WHERE R = 1" ).append("\n"); 

	}
}