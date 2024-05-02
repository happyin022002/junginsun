/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : CntrMtyRouteSettingDBDAOCntrMtyRouteSettingListUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.07.28
*@LastModifier : 
*@LastVersion : 1.0
* 2016.07.28 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.eqr.cntrmtybkgmanage.cntrmtyroutesetting.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CntrMtyRouteSettingDBDAOCntrMtyRouteSettingListUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * CntrMtyRouteSettingDBDAOCntrMtyRouteSettingList
	  * </pre>
	  */
	public CntrMtyRouteSettingDBDAOCntrMtyRouteSettingListUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("loc_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mty_bkg_dsabil_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mty_split_bkg_dsabil_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("lodg_dchg_div_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.eqr.cntrmtybkgmanage.cntrmtyroutesetting.integration").append("\n"); 
		query.append("FileName : CntrMtyRouteSettingDBDAOCntrMtyRouteSettingListUSQL").append("\n"); 
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
		query.append("MERGE INTO EQR_CTRL_ROUT_SET A" ).append("\n"); 
		query.append("USING DUAL ON (A.LODG_DCHG_DIV_CD = @[lodg_dchg_div_cd]" ).append("\n"); 
		query.append("               AND A.LOC_CD = @[loc_nm]" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("WHEN MATCHED" ).append("\n"); 
		query.append("THEN UPDATE SET " ).append("\n"); 
		query.append("             A.MTY_BKG_DSABIL_FLG = @[mty_bkg_dsabil_flg]" ).append("\n"); 
		query.append("            ,A.MTY_SPLIT_BKG_DSABIL_FLG = @[mty_split_bkg_dsabil_flg]" ).append("\n"); 
		query.append("            ,A.UPD_DT = SYSDATE" ).append("\n"); 
		query.append("            ,A.UPD_USR_ID = @[usr_id]             " ).append("\n"); 
		query.append("     WHERE  1=1" ).append("\n"); 
		query.append("       AND A.LODG_DCHG_DIV_CD = @[lodg_dchg_div_cd]" ).append("\n"); 
		query.append("       AND A.LOC_CD = @[loc_nm]" ).append("\n"); 
		query.append("WHEN NOT MATCHED" ).append("\n"); 
		query.append("THEN INSERT (A.LODG_DCHG_DIV_CD" ).append("\n"); 
		query.append("            ,A.LOC_CD" ).append("\n"); 
		query.append("            ,A.RCC_CD" ).append("\n"); 
		query.append("            ,A.MTY_BKG_DSABIL_FLG" ).append("\n"); 
		query.append("            ,A.MTY_SPLIT_BKG_DSABIL_FLG" ).append("\n"); 
		query.append("            ,A.UPD_DT" ).append("\n"); 
		query.append("            ,A.UPD_USR_ID" ).append("\n"); 
		query.append("            ,A.CRE_DT" ).append("\n"); 
		query.append("            ,A.CRE_USR_ID" ).append("\n"); 
		query.append("            )" ).append("\n"); 
		query.append("     VALUES (@[lodg_dchg_div_cd]          " ).append("\n"); 
		query.append("            ,@[loc_nm]" ).append("\n"); 
		query.append("            ,(SELECT A.RCC_CD RCC" ).append("\n"); 
		query.append("                FROM MDM_EQ_ORZ_CHT A, MDM_LOCATION B" ).append("\n"); 
		query.append("               WHERE A.SCC_CD = B.SCC_CD" ).append("\n"); 
		query.append("                AND B.LOC_CD = @[loc_nm])" ).append("\n"); 
		query.append("            ,@[mty_bkg_dsabil_flg]" ).append("\n"); 
		query.append("            ,@[mty_split_bkg_dsabil_flg]  " ).append("\n"); 
		query.append("            ,SYSDATE        " ).append("\n"); 
		query.append("            ,@[usr_id]                     " ).append("\n"); 
		query.append("            ,SYSDATE              " ).append("\n"); 
		query.append("            ,@[usr_id]                 " ).append("\n"); 
		query.append("     )" ).append("\n"); 

	}
}