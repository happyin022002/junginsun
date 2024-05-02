/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : MalaysiaManifestListDownloadDBDAOSearchCustomsCNTRInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.02.13
*@LastModifier : 
*@LastVersion : 1.0
* 2013.02.13 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.malaysia.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class MalaysiaManifestListDownloadDBDAOSearchCustomsCNTRInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 2012.02.02 변종건 [CHM-201215473-01] Malaysis (MYTPP) Customs Manifest 전송 기능 추가 요청
	  * </pre>
	  */
	public MalaysiaManifestListDownloadDBDAOSearchCustomsCNTRInfoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_pol_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_trunk_por_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_pod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_trunk_pol_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_trunk_del_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_vvd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_trunk_pod_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.malaysia.integration").append("\n"); 
		query.append("FileName : MalaysiaManifestListDownloadDBDAOSearchCustomsCNTRInfoRSQL").append("\n"); 
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
		query.append("SELECT    B.BL_NO" ).append("\n"); 
		query.append(",C.CNTR_NO" ).append("\n"); 
		query.append(",C.CNTR_TPSZ_CD" ).append("\n"); 
		query.append(",S.CNTR_SEAL_NO" ).append("\n"); 
		query.append(",C.PCK_QTY" ).append("\n"); 
		query.append(",C.PCK_TP_CD" ).append("\n"); 
		query.append(",C.CNTR_WGT" ).append("\n"); 
		query.append(",C.WGT_UT_CD" ).append("\n"); 
		query.append(",C.MEAS_QTY" ).append("\n"); 
		query.append(",C.MEAS_UT_CD" ).append("\n"); 
		query.append("FROM      BKG_VVD V, BKG_BOOKING B, BKG_CONTAINER C, BKG_CNTR_SEAL_NO S" ).append("\n"); 
		query.append("WHERE     1 = 1" ).append("\n"); 
		query.append("AND       V.VSL_CD = SUBSTR(@[s_vvd],1,4)" ).append("\n"); 
		query.append("AND       V.SKD_VOY_NO = SUBSTR(@[s_vvd],5,4)" ).append("\n"); 
		query.append("AND       V.SKD_DIR_CD = SUBSTR(@[s_vvd],9,1)" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${s_pod_cd} != '')" ).append("\n"); 
		query.append("AND       V.POD_CD = @[s_pod_cd]        --Mode=Inbound 조건" ).append("\n"); 
		query.append("#if (${ts_tp_cd} == 'T')" ).append("\n"); 
		query.append("AND       V.POD_CD <> B.POD_CD" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("AND       V.POD_CD = B.POD_CD" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${s_pol_cd} != '')" ).append("\n"); 
		query.append("AND       V.POL_CD = @[s_pol_cd]        --Mode=Outbound 조건" ).append("\n"); 
		query.append("#if (${ts_tp_cd} == 'T')" ).append("\n"); 
		query.append("AND       V.POL_CD <> B.POL_CD" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("AND       V.POL_CD = B.POL_CD" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("AND       B.BKG_NO = V.BKG_NO" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${s_trunk_por_cd} != '')" ).append("\n"); 
		query.append("AND       B.POR_CD = @[s_trunk_por_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${s_trunk_pol_cd} != '')" ).append("\n"); 
		query.append("AND       B.POL_CD = @[s_trunk_pol_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${s_trunk_pod_cd} != '')" ).append("\n"); 
		query.append("AND       B.POD_CD = @[s_trunk_pod_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${s_trunk_del_cd} != '')" ).append("\n"); 
		query.append("AND       B.DEL_CD = @[s_trunk_del_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("AND       B.BKG_STS_CD <> 'X'" ).append("\n"); 
		query.append("AND       C.BKG_NO(+) = B.BKG_NO" ).append("\n"); 
		query.append("AND       S.BKG_NO(+) = C.BKG_NO" ).append("\n"); 
		query.append("AND       S.CNTR_NO(+) = C.CNTR_NO" ).append("\n"); 
		query.append("AND       S.CNTR_SEAL_SEQ(+) = 1" ).append("\n"); 

	}
}