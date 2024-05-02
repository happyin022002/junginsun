/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : ReplanManageDBDAOSearchBfrCombineCopInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.01.23
*@LastModifier : 홍성필
*@LastVersion : 1.0
* 2017.01.23 홍성필
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.sce.replanmanage.replanmanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Hong Seong Pil
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ReplanManageDBDAOSearchBfrCombineCopInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Combine 된 booking no 로 Combine 되기 이전 booking 의 COP 정보를 조회한다.
	  * </pre>
	  */
	public ReplanManageDBDAOSearchBfrCombineCopInfoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.sce.replanmanage.replanmanage.integration").append("\n"); 
		query.append("FileName : ReplanManageDBDAOSearchBfrCombineCopInfoRSQL").append("\n"); 
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
		query.append("  CH.COP_NO," ).append("\n"); 
		query.append("  CH.BKG_NO," ).append("\n"); 
		query.append("  CH.CNTR_NO," ).append("\n"); 
		query.append("  CH.CNTR_TPSZ_CD," ).append("\n"); 
		query.append("  CH.CNMV_YR," ).append("\n"); 
		query.append("  CH.COP_STS_CD," ).append("\n"); 
		query.append("  CH.PCTL_NO," ).append("\n"); 
		query.append("  CH.MST_COP_NO," ).append("\n"); 
		query.append("  CH.COP_FSH_DT," ).append("\n"); 
		query.append("  CH.TRNK_VSL_CD," ).append("\n"); 
		query.append("  CH.TRNK_SKD_VOY_NO," ).append("\n"); 
		query.append("  CH.TRNK_SKD_DIR_CD," ).append("\n"); 
		query.append("  CH.POR_NOD_CD," ).append("\n"); 
		query.append("  CH.POL_NOD_CD," ).append("\n"); 
		query.append("  CH.POD_NOD_CD," ).append("\n"); 
		query.append("  CH.DEL_NOD_CD," ).append("\n"); 
		query.append("  CH.COP_RAIL_CHK_CD," ).append("\n"); 
		query.append("  CH.IB_TRO_FLG," ).append("\n"); 
		query.append("  CH.OB_TRO_FLG," ).append("\n"); 
		query.append("  CH.RAIL_RCV_COFF_DT_SRC_TP_CD," ).append("\n"); 
		query.append("  TO_CHAR(CH.RAIL_RCV_COFF_FM_DT, 'YYYYMMDDHH24MISS') AS RAIL_RCV_COFF_FM_DT," ).append("\n"); 
		query.append("  TO_CHAR(CH.RAIL_RCV_COFF_TO_DT, 'YYYYMMDDHH24MISS') AS RAIL_RCV_COFF_TO_DT," ).append("\n"); 
		query.append("  CH.CRE_USR_ID," ).append("\n"); 
		query.append("  TO_CHAR(CH.CRE_DT, 'YYYYMMDDHH24MISS') AS CRE_DT," ).append("\n"); 
		query.append("  CH.UPD_USR_ID," ).append("\n"); 
		query.append("  TO_CHAR(CH.UPD_DT, 'YYYYMMDDHH24MISS') AS UPD_DT," ).append("\n"); 
		query.append("  CH.COP_SUB_STS_CD" ).append("\n"); 
		query.append("    FROM SCE_COP_HDR CH," ).append("\n"); 
		query.append("        (" ).append("\n"); 
		query.append("            SELECT BKG_NO, BKG_STS_CD" ).append("\n"); 
		query.append("            FROM BKG_BOOKING" ).append("\n"); 
		query.append("            WHERE TO_BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("                " ).append("\n"); 
		query.append("        ) BK" ).append("\n"); 
		query.append("    WHERE CH.BKG_NO = BK.BKG_NO" ).append("\n"); 
		query.append("#if (${cntr_no} != '')" ).append("\n"); 
		query.append("        AND CH.CNTR_NO  =  @[cntr_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}