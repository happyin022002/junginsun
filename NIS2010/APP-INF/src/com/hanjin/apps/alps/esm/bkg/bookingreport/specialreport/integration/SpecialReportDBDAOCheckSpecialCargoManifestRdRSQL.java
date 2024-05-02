/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : SpecialReportDBDAOCheckSpecialCargoManifestRdRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.02.04
*@LastModifier : 이영헌
*@LastVersion : 1.0
* 2013.02.04 이영헌
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingreport.specialreport.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author YoungHeon Lee
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SpecialReportDBDAOCheckSpecialCargoManifestRdRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SpecialCargo Manifest의 RD 존재 유무 조회
	  * </pre>
	  */
	public SpecialReportDBDAOCheckSpecialCargoManifestRdRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vvd_pod",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("del_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pol_yd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("por_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pod_yd_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("vvd_pol",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingreport.specialreport.integration").append("\n"); 
		query.append("FileName : SpecialReportDBDAOCheckSpecialCargoManifestRdRSQL").append("\n"); 
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
		query.append("SELECT DECODE(SUM(CASE WHEN SP.BKG_SPE_DG = 'Y' " ).append("\n"); 
		query.append("                        THEN (SELECT COUNT(*) FROM BKG_DG_CGO DG" ).append("\n"); 
		query.append("                              WHERE DG.BKG_NO = SP.BKG_NO" ).append("\n"); 
		query.append("                              AND SP.BKG_SPE_DG = 'Y'" ).append("\n"); 
		query.append("                              AND NVL(DG.SPCL_CGO_APRO_CD,'') <> 'C')" ).append("\n"); 
		query.append("                        ELSE 0 END), 0, 'N', 'Y') DG," ).append("\n"); 
		query.append("       DECODE(SUM(CASE WHEN SP.BKG_SPE_AK = 'Y'" ).append("\n"); 
		query.append("                        THEN (SELECT COUNT(*) FROM BKG_AWK_CGO AWK" ).append("\n"); 
		query.append("                              WHERE AWK.BKG_NO = SP.BKG_NO" ).append("\n"); 
		query.append("                              AND SP.BKG_SPE_AK = 'Y'" ).append("\n"); 
		query.append("                              AND NVL(AWK.SPCL_CGO_APRO_CD,' ') <> 'C')" ).append("\n"); 
		query.append("                        ELSE 0 END), 0, 'N', 'Y') AWK," ).append("\n"); 
		query.append("       DECODE(SUM(CASE WHEN SP.BKG_SPE_BB = 'Y'" ).append("\n"); 
		query.append("                        THEN (SELECT COUNT(*) FROM BKG_BB_CGO BB" ).append("\n"); 
		query.append("                              WHERE BB.BKG_NO = SP.BKG_NO" ).append("\n"); 
		query.append("                              AND SP.BKG_SPE_BB = 'Y'" ).append("\n"); 
		query.append("                              AND NVL(BB.SPCL_CGO_APRO_CD,' ') <> 'C')" ).append("\n"); 
		query.append("                        ELSE 0 END), 0, 'N', 'Y') BB," ).append("\n"); 
		query.append("       DECODE(SUM(CASE WHEN SP.BKG_SPE_RF = 'Y'" ).append("\n"); 
		query.append("                        THEN (SELECT COUNT(*) FROM BKG_RF_CGO RF" ).append("\n"); 
		query.append("                              WHERE RF.BKG_NO = SP.BKG_NO" ).append("\n"); 
		query.append("                              AND SP.BKG_SPE_RF = 'Y'" ).append("\n"); 
		query.append("                              AND NVL(RF.SPCL_CGO_APRO_CD,' ') <> 'C')" ).append("\n"); 
		query.append("                        ELSE 0 END), 0, 'N', 'Y') RF," ).append("\n"); 
		query.append("       DECODE(SUM(DECODE(BKG.STWG_CD, NULL, 0, 1)), 0, 'N', 'Y') STWG" ).append("\n"); 
		query.append("FROM BKG_SP_V SP, BKG_BOOKING BKG" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("#if(${rdo_in_out} == 'IN')" ).append("\n"); 
		query.append("	#if(${rdo_local_ts} == 'LOCAL')" ).append("\n"); 
		query.append("	AND BKG.POD_CD = SP.VVD_POD" ).append("\n"); 
		query.append("	#elseif(${rdo_local_ts} == 'TS')" ).append("\n"); 
		query.append("	AND BKG.POD_CD <> SP.VVD_POD" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("#elseif(${rdo_in_out} == 'OUT')" ).append("\n"); 
		query.append("	#if(${rdo_local_ts} == 'LOCAL')" ).append("\n"); 
		query.append("	AND BKG.POL_CD = SP.VVD_POL" ).append("\n"); 
		query.append("	#elseif(${rdo_local_ts} == 'TS')" ).append("\n"); 
		query.append("	AND BKG.POD_CD <> SP.VVD_POL" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("AND SP.VSL_CD = @[vsl_cd]  /*VVD*/" ).append("\n"); 
		query.append("AND SP.SKD_VOY_NO = @[skd_voy_no]  /*VVD*/" ).append("\n"); 
		query.append("AND SP.SKD_DIR_CD = @[skd_dir_cd]  /*VVD*/" ).append("\n"); 
		query.append("#if(${vvd_pol} != '')" ).append("\n"); 
		query.append("AND SP.VVD_POL = @[vvd_pol]  /*VVD_POL*/" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${vvd_pod} != '')" ).append("\n"); 
		query.append("AND SP.VVD_POD = @[vvd_pod]  /*VVD_POD*/" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${pol_yd_cd} != '')" ).append("\n"); 
		query.append("AND NVL(SUBSTR(SP.POL_YD_CD, 6, 2), ' ') = @[pol_yd_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${pod_yd_cd} != '')" ).append("\n"); 
		query.append("AND NVL(SUBSTR(SP.POD_YD_CD, 6, 2), ' ') = @[pod_yd_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("AND SP.BKG_NO = BKG.BKG_NO" ).append("\n"); 
		query.append("#if(${por_cd} != '')" ).append("\n"); 
		query.append("AND BKG.POR_CD = @[por_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${pol_cd} != '')" ).append("\n"); 
		query.append("AND BKG.POL_CD = @[pol_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${pod_cd} != '')" ).append("\n"); 
		query.append("AND BKG.POD_CD = @[pod_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${del_cd} != '')" ).append("\n"); 
		query.append("AND BKG.DEL_CD = @[del_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}