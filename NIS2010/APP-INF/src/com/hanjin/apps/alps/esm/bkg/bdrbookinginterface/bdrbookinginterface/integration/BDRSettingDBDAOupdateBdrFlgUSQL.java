/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : BDRSettingDBDAOupdateBdrFlgUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.05.11
*@LastModifier : 김기종
*@LastVersion : 1.0
* 2010.05.11 김기종
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bdrbookinginterface.bdrbookinginterface.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Kim Ki Jong
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BDRSettingDBDAOupdateBdrFlgUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * updateBdrFlg
	  * </pre>
	  */
	public BDRSettingDBDAOupdateBdrFlgUSQL(){
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
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.batch.bdrbookinginterface.integration").append("\n"); 
		query.append("FileName : BDRSettingDBDAOupdateBdrFlgUSQL").append("\n"); 
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
		query.append("UPDATE BKG_VVD_BDR_LOG" ).append("\n"); 
		query.append("SET" ).append("\n"); 
		query.append("#if ('TRNK'==${upd_cd})" ).append("\n"); 
		query.append("TRNK_BDR_FLG = 'Y'," ).append("\n"); 
		query.append("TRNK_AUTO_BDR_FLG = 'Y'," ).append("\n"); 
		query.append("TRNK_AUTO_BDR_DT = GLOBALDATE_PKG.TIME_CONV_FNC('KRPUS',SYSDATE-1,POL_CD)," ).append("\n"); 
		query.append("#elseif ('FDR'==${upd_cd})" ).append("\n"); 
		query.append("FDR_BDR_FLG = 'Y'," ).append("\n"); 
		query.append("FDR_AUTO_BDR_FLG = 'Y'," ).append("\n"); 
		query.append("FDR_AUTO_BDR_DT = GLOBALDATE_PKG.TIME_CONV_FNC('KRPUS',SYSDATE-1,POL_CD)," ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("UPD_USR_ID = 'BDRBookingSetting'," ).append("\n"); 
		query.append("UPD_DT = SYSDATE" ).append("\n"); 
		query.append("WHERE  VSL_CD = @[vsl_cd]" ).append("\n"); 
		query.append("AND    SKD_VOY_NO = @[skd_voy_no]" ).append("\n"); 
		query.append("AND    SKD_DIR_CD = @[skd_dir_cd]" ).append("\n"); 
		query.append("AND    POL_CD = @[pol_cd]" ).append("\n"); 
		query.append("AND    POD_CD = @[pod_cd]" ).append("\n"); 
		query.append("#if ('TRNK'==${upd_cd})" ).append("\n"); 
		query.append("AND    'N' = TRNK_BDR_FLG" ).append("\n"); 
		query.append("#elseif ('FDR'==${upd_cd})" ).append("\n"); 
		query.append("AND    'N' = FDR_BDR_FLG" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}