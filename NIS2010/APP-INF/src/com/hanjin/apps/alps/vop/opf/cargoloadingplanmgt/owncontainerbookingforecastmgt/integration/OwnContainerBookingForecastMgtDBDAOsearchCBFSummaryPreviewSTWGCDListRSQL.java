/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : OwnContainerBookingForecastMgtDBDAOsearchCBFSummaryPreviewSTWGCDListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.01.19
*@LastModifier : 
*@LastVersion : 1.0
* 2017.01.19 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.opf.cargoloadingplanmgt.owncontainerbookingforecastmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class OwnContainerBookingForecastMgtDBDAOsearchCBFSummaryPreviewSTWGCDListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchCBFSummaryPreviewSTWGCDList 조회
	  * </pre>
	  */
	public OwnContainerBookingForecastMgtDBDAOsearchCBFSummaryPreviewSTWGCDListRSQL(){
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
		params.put("qty1",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("qty3",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("qty2",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("qty5",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("qty4",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.vop.opf.cargoloadingplanmgt.owncontainerbookingforecastmgt.integration").append("\n"); 
		query.append("FileName : OwnContainerBookingForecastMgtDBDAOsearchCBFSummaryPreviewSTWGCDListRSQL").append("\n"); 
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
		query.append("SELECT DISTINCT A.CRR_CD, A.STWG_CD, B.INTG_CD_VAL_DESC STWG_NM" ).append("\n"); 
		query.append("  FROM OPF_CGO_BKG_FCAST_CNTR A" ).append("\n"); 
		query.append("     , COM_INTG_CD_DTL        B" ).append("\n"); 
		query.append(" WHERE A.VSL_CD                    = @[vsl_cd]" ).append("\n"); 
		query.append("   AND A.SKD_VOY_NO                = @[skd_voy_no]" ).append("\n"); 
		query.append("   AND A.SKD_DIR_CD                = @[skd_dir_cd]" ).append("\n"); 
		query.append("   AND A.YD_CD||A.POL_CLPT_IND_SEQ = @[yd_cd]" ).append("\n"); 
		query.append("#if (${crr_cd} != '' && ${crr_cd} != 'ALL')" ).append("\n"); 
		query.append("   AND A.CRR_CD       = @[crr_cd]" ).append("\n"); 
		query.append("#elseif (${qty1} != '')" ).append("\n"); 
		query.append("   AND A.CRR_CD IN ( @[qty1], @[qty2], @[qty3], @[qty4], @[qty5] )" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("   AND A.CBF_DP_CD    = 'S'" ).append("\n"); 
		query.append("   AND A.STWG_CGO_FLG = 'Y'" ).append("\n"); 
		query.append("   AND A.STWG_CD IS NOT NULL" ).append("\n"); 
		query.append("   AND A.STWG_CD      = B.INTG_CD_VAL_CTNT(+)" ).append("\n"); 
		query.append("   AND B.INTG_CD_ID(+) = 'CD02146'" ).append("\n"); 
		query.append(" ORDER BY DECODE(A.CRR_CD,'SML','1',A.CRR_CD), A.STWG_CD" ).append("\n"); 

	}
}