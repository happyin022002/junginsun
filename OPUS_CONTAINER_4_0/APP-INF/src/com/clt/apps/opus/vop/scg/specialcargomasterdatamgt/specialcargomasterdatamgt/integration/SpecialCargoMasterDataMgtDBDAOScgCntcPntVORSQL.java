/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : SpecialCargoMasterDataMgtDBDAOScgCntcPntVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.06.02
*@LastModifier : 
*@LastVersion : 1.0
* 2015.06.02 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.scg.specialcargomasterdatamgt.specialcargomasterdatamgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SpecialCargoMasterDataMgtDBDAOScgCntcPntVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Partner’s Contact Point for SPCL CGO (Creation) 조회
	  * </pre>
	  */
	public SpecialCargoMasterDataMgtDBDAOScgCntcPntVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("delt_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rgn_shp_opr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("slan_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("spcl_cgo_cate_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.vop.scg.specialcargomasterdatamgt.specialcargomasterdatamgt.integration").append("\n"); 
		query.append("FileName : SpecialCargoMasterDataMgtDBDAOScgCntcPntVORSQL").append("\n"); 
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
		query.append("	RGN_SHP_OPR_CD" ).append("\n"); 
		query.append(",	CRR_CD" ).append("\n"); 
		query.append(",	SLAN_CD" ).append("\n"); 
		query.append(",	SPCL_CGO_CATE_CD" ).append("\n"); 
		query.append(",	VSL_OPR_NM" ).append("\n"); 
		query.append(",	CNTC_PSON_EML_CTNT" ).append("\n"); 
		query.append(",	CNTC_PSON_PHN_NO" ).append("\n"); 
		query.append(",	CNTC_PSON_FAX_NO" ).append("\n"); 
		query.append(",	NVL(DELT_FLG,'N') AS DELT_FLG" ).append("\n"); 
		query.append(",	CRE_USR_ID" ).append("\n"); 
		query.append(",	CRE_DT" ).append("\n"); 
		query.append(",	UPD_USR_ID" ).append("\n"); 
		query.append(",	UPD_DT" ).append("\n"); 
		query.append("FROM SCG_CNTC_PNT" ).append("\n"); 
		query.append("WHERE	1 = 1" ).append("\n"); 
		query.append("#if (${delt_flg} != '') " ).append("\n"); 
		query.append("AND NVL(DELT_FLG,'N') = @[delt_flg]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${rgn_shp_opr_cd} != '') " ).append("\n"); 
		query.append("AND RGN_SHP_OPR_CD = @[rgn_shp_opr_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${crr_cd} != '') " ).append("\n"); 
		query.append("AND CRR_CD = @[crr_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${slan_cd} != '') " ).append("\n"); 
		query.append("AND SLAN_CD = @[slan_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${spcl_cgo_cate_cd} != '') " ).append("\n"); 
		query.append("AND SPCL_CGO_CATE_CD = @[spcl_cgo_cate_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("AND SPCL_CGO_CATE_CD IN ('AK', 'DG', 'RF', 'SS')" ).append("\n"); 
		query.append("ORDER BY DECODE(CRR_CD, 'COM', 1), DECODE(SLAN_CD,'COM', 1), RGN_SHP_OPR_CD, CRR_CD, SLAN_CD, SPCL_CGO_CATE_CD" ).append("\n"); 

	}
}