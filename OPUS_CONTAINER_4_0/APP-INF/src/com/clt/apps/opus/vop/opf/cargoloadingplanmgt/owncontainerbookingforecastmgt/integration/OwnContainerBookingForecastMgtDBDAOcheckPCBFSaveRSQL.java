/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : OwnContainerBookingForecastMgtDBDAOcheckPCBFSaveRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.03.04
*@LastModifier : 
*@LastVersion : 1.0
* 2011.03.04 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.opf.cargoloadingplanmgt.owncontainerbookingforecastmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class OwnContainerBookingForecastMgtDBDAOcheckPCBFSaveRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * checkPCBFSave
	  * </pre>
	  */
	public OwnContainerBookingForecastMgtDBDAOcheckPCBFSaveRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("yd_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("crr_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("Path : com.clt.apps.opus.vop.opf.cargoloadingplanmgt.owncontainerbookingforecastmgt.integration").append("\n"); 
		query.append("FileName : OwnContainerBookingForecastMgtDBDAOcheckPCBFSaveRSQL").append("\n"); 
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
		query.append("COUNT(*) CBFCOUNT  " ).append("\n"); 
		query.append("FROM OPF_CGO_BKG_FCAST_CNTR A, OPF_CGO_BKG_FCAST B" ).append("\n"); 
		query.append("WHERE  A.VSL_CD = @[vsl_cd]" ).append("\n"); 
		query.append("AND    A.SKD_VOY_NO = @[skd_voy_no]" ).append("\n"); 
		query.append("AND    A.SKD_DIR_CD = @[skd_dir_cd]" ).append("\n"); 
		query.append("AND    A.YD_CD||A.POL_CLPT_IND_SEQ = @[yd_cd]" ).append("\n"); 
		query.append("AND    A.CRR_CD = @[crr_cd]" ).append("\n"); 
		query.append("AND    A.BKG_SHPR_OWNR_FLG = 'N'" ).append("\n"); 
		query.append("AND    A.CRR_CD <> COM_ConstantMgr_PKG.COM_getCompanyCode_FNC()" ).append("\n"); 
		query.append("AND    B.VSL_CD = A.VSL_CD                                                    " ).append("\n"); 
		query.append("AND    B.SKD_VOY_NO = A.SKD_VOY_NO                                                    " ).append("\n"); 
		query.append("AND    B.SKD_DIR_CD = A.SKD_DIR_CD                                                    " ).append("\n"); 
		query.append("AND    B.BKG_SHPR_OWNR_FLG = A.BKG_SHPR_OWNR_FLG" ).append("\n"); 
		query.append("AND    B.CRR_CD = A.CRR_CD" ).append("\n"); 
		query.append("AND    B.YD_CD = A.YD_CD" ).append("\n"); 
		query.append("AND    A.CBF_DP_CD = 'V'" ).append("\n"); 

	}
}