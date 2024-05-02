/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : SpecialCargoQuotationManageDBDAOcheckYdCdInputAuthAddonRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.04.11
*@LastModifier : 이혜민
*@LastVersion : 1.0
* 2013.04.11 이혜민
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.tes.specialcargoquotationmanage.awkwardcargomanage.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Hyemin Lee
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SpecialCargoQuotationManageDBDAOcheckYdCdInputAuthAddonRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * checkYdCdInputAuthAddon
	  * </pre>
	  */
	public SpecialCargoQuotationManageDBDAOcheckYdCdInputAuthAddonRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fm_yd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("lg_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("to_yd_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.tes.specialcargoquotationmanage.awkwardcargomanage.integration ").append("\n"); 
		query.append("FileName : SpecialCargoQuotationManageDBDAOcheckYdCdInputAuthAddonRSQL").append("\n"); 
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
		query.append("CASE" ).append("\n"); 
		query.append("WHEN (" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("CASE" ).append("\n"); 
		query.append("WHEN LENGTH(@[fm_yd_cd])=7" ).append("\n"); 
		query.append("THEN" ).append("\n"); 
		query.append("(SELECT" ).append("\n"); 
		query.append("NVL(TES_OOG_GET_AUTH_YN_FNC(@[lg_ofc_cd],(SELECT OFC_CD" ).append("\n"); 
		query.append("FROM MDM_YARD" ).append("\n"); 
		query.append("WHERE YD_CD = @[fm_yd_cd]" ).append("\n"); 
		query.append("AND NVL(DELT_FLG,'N')<>'Y')),'X')" ).append("\n"); 
		query.append("FROM DUAL)" ).append("\n"); 
		query.append("WHEN LENGTH(@[fm_yd_cd])=5" ).append("\n"); 
		query.append("THEN" ).append("\n"); 
		query.append("(SELECT" ).append("\n"); 
		query.append("NVL(" ).append("\n"); 
		query.append("(SELECT" ).append("\n"); 
		query.append("DISTINCT TES_OOG_GET_AUTH_YN_FNC(@[lg_ofc_cd], OFC_CD)" ).append("\n"); 
		query.append("FROM MDM_YARD" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND YD_CD LIKE @[fm_yd_cd]||'%'" ).append("\n"); 
		query.append("AND NVL(DELT_FLG,'N')<>'Y'" ).append("\n"); 
		query.append("AND NVL(TES_OOG_GET_AUTH_YN_FNC(@[lg_ofc_cd], OFC_CD),'N') = 'Y'),'X')" ).append("\n"); 
		query.append("FROM DUAL)" ).append("\n"); 
		query.append("ELSE 'X'" ).append("\n"); 
		query.append("END CHK" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 
		query.append(") = 'Y'" ).append("\n"); 
		query.append("THEN 'Y'" ).append("\n"); 
		query.append("WHEN (" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("CASE" ).append("\n"); 
		query.append("WHEN LENGTH(@[to_yd_cd])=7" ).append("\n"); 
		query.append("THEN" ).append("\n"); 
		query.append("(SELECT" ).append("\n"); 
		query.append("NVL(TES_OOG_GET_AUTH_YN_FNC(@[lg_ofc_cd],(SELECT OFC_CD" ).append("\n"); 
		query.append("FROM MDM_YARD" ).append("\n"); 
		query.append("WHERE YD_CD = @[to_yd_cd]" ).append("\n"); 
		query.append("AND NVL(DELT_FLG,'N')<>'Y')),'X')" ).append("\n"); 
		query.append("FROM DUAL)" ).append("\n"); 
		query.append("WHEN LENGTH(@[to_yd_cd])=5" ).append("\n"); 
		query.append("THEN" ).append("\n"); 
		query.append("(SELECT" ).append("\n"); 
		query.append("NVL(" ).append("\n"); 
		query.append("(SELECT" ).append("\n"); 
		query.append("DISTINCT TES_OOG_GET_AUTH_YN_FNC(@[lg_ofc_cd], OFC_CD)" ).append("\n"); 
		query.append("FROM MDM_YARD" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND YD_CD LIKE @[to_yd_cd]||'%'" ).append("\n"); 
		query.append("AND NVL(DELT_FLG,'N')<>'Y'" ).append("\n"); 
		query.append("AND NVL(TES_OOG_GET_AUTH_YN_FNC(@[lg_ofc_cd], OFC_CD),'N') = 'Y'),'X')" ).append("\n"); 
		query.append("FROM DUAL)" ).append("\n"); 
		query.append("ELSE 'X'" ).append("\n"); 
		query.append("END CHK" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 
		query.append(") = 'Y'" ).append("\n"); 
		query.append("THEN 'Y'" ).append("\n"); 
		query.append("ELSE 'N'" ).append("\n"); 
		query.append("END CHK_FLG" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 

	}
}