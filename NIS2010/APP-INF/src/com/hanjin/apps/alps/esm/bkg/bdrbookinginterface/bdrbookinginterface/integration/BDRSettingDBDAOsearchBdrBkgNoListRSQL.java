/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : BDRSettingDBDAOsearchBdrBkgNoListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.09.02
*@LastModifier : 김태경
*@LastVersion : 1.0
* 2010.09.02 김태경
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bdrbookinginterface.bdrbookinginterface.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author kim tae kyoung
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BDRSettingDBDAOsearchBdrBkgNoListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchBdrBkgNoList
	  * </pre>
	  */
	public BDRSettingDBDAOsearchBdrBkgNoListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("skd_dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pol_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("skd_voy_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("upd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bdrbookinginterface.bdrbookinginterface.integration").append("\n"); 
		query.append("FileName : BDRSettingDBDAOsearchBdrBkgNoListRSQL").append("\n"); 
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
		query.append("SELECT BKG.BKG_NO," ).append("\n"); 
		query.append("       BKG.BL_NO," ).append("\n"); 
		query.append("       TO_CHAR(SYSDATE,'RRRRMMDDHH24MISS') AS EVNT_DT," ).append("\n"); 
		query.append("       --O.B/L Relesae값(OblRdemFlg) 은 Surrender 또는 SeaWaybill 인 경우만 'Y'입니다. (나머지는 'N')" ).append("\n"); 
		query.append("       CASE WHEN 'WY'=BKG.BL_TP_CD||ISS.OBL_RLSE_FLG THEN 'Y'" ).append("\n"); 
		query.append("            WHEN 'Y'=ISS.OBL_SRND_FLG THEN 'Y'" ).append("\n"); 
		query.append("            ELSE 'N' END AS OBL_RLSE_FLG" ).append("\n"); 
		query.append("	   ,@[upd_cd] UPD_CD	" ).append("\n"); 
		query.append("FROM   BKG_BOOKING BKG," ).append("\n"); 
		query.append("       BKG_VVD VVD," ).append("\n"); 
		query.append("       BKG_BL_DOC DOC," ).append("\n"); 
		query.append("       BKG_BL_ISS ISS" ).append("\n"); 
		query.append("WHERE  1=1" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${upd_cd} == 'TRNK') " ).append("\n"); 
		query.append("AND	   'T' = VVD.VSL_PRE_PST_CD" ).append("\n"); 
		query.append("AND    0 = VVD.VSL_SEQ" ).append("\n"); 
		query.append("#elseif (${upd_cd} == 'FDR') " ).append("\n"); 
		query.append("AND	   'T' <> VVD.VSL_PRE_PST_CD" ).append("\n"); 
		query.append("AND    0 < VVD.VSL_SEQ" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("AND    BKG.BKG_NO = VVD.BKG_NO" ).append("\n"); 
		query.append("AND    BKG.BKG_NO = DOC.BKG_NO" ).append("\n"); 
		query.append("AND    'N' = DOC.BDR_FLG" ).append("\n"); 
		query.append("AND    BKG.BKG_STS_CD IN ('S','F')" ).append("\n"); 
		query.append("AND    BKG.BKG_NO = ISS.BKG_NO(+)" ).append("\n"); 
		query.append("AND    @[vsl_cd] = VVD.VSL_CD" ).append("\n"); 
		query.append("AND    @[skd_voy_no] = VVD.SKD_VOY_NO" ).append("\n"); 
		query.append("AND    @[skd_dir_cd] = VVD.SKD_DIR_CD" ).append("\n"); 
		query.append("AND    @[pol_cd] = VVD.POL_CD" ).append("\n"); 
		query.append("AND    @[pod_cd] = VVD.POD_CD" ).append("\n"); 

	}
}