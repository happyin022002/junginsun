/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : ReplanManageDBDAOSearchBfSplitCopInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.01.26
*@LastModifier : 김인수
*@LastVersion : 1.0
* 2010.01.26 김인수
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.sce.replanmanage.replanmanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Kim In-soo
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ReplanManageDBDAOSearchBfSplitCopInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Split 된 booking 으로 Split 되기 원 booking 의 cop 정보를 조회 한다.
	  * </pre>
	  */
	public ReplanManageDBDAOSearchBfSplitCopInfoRSQL(){
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
		query.append("FileName : ReplanManageDBDAOSearchBfSplitCopInfoRSQL").append("\n"); 
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
		query.append("SELECT CH.COP_NO," ).append("\n"); 
		query.append("CH.BKG_NO," ).append("\n"); 
		query.append("CH.CNTR_NO," ).append("\n"); 
		query.append("CH.CNTR_TPSZ_CD," ).append("\n"); 
		query.append("CH.CNMV_YR," ).append("\n"); 
		query.append("CH.COP_STS_CD," ).append("\n"); 
		query.append("CH.PCTL_NO," ).append("\n"); 
		query.append("CH.MST_COP_NO," ).append("\n"); 
		query.append("TO_CHAR(CH.COP_FSH_DT, 'YYYYMMDDHH24MISS') AS COP_FSH_DT," ).append("\n"); 
		query.append("CH.TRNK_VSL_CD," ).append("\n"); 
		query.append("CH.TRNK_SKD_VOY_NO," ).append("\n"); 
		query.append("CH.TRNK_SKD_DIR_CD," ).append("\n"); 
		query.append("CH.POR_NOD_CD," ).append("\n"); 
		query.append("CH.POL_NOD_CD," ).append("\n"); 
		query.append("CH.POD_NOD_CD," ).append("\n"); 
		query.append("CH.DEL_NOD_CD," ).append("\n"); 
		query.append("CH.COP_RAIL_CHK_CD," ).append("\n"); 
		query.append("CH.IB_TRO_FLG," ).append("\n"); 
		query.append("CH.OB_TRO_FLG," ).append("\n"); 
		query.append("CH.RAIL_RCV_COFF_DT_SRC_TP_CD," ).append("\n"); 
		query.append("TO_CHAR(CH.RAIL_RCV_COFF_FM_DT, 'YYYYMMDDHH24MISS') AS RAIL_RCV_COFF_FM_DT," ).append("\n"); 
		query.append("TO_CHAR(CH.RAIL_RCV_COFF_TO_DT, 'YYYYMMDDHH24MISS') AS RAIL_RCV_COFF_TO_DT," ).append("\n"); 
		query.append("CH.CRE_USR_ID," ).append("\n"); 
		query.append("TO_CHAR(CH.CRE_DT, 'YYYYMMDDHH24MISS') AS CRE_DT," ).append("\n"); 
		query.append("CH.UPD_USR_ID," ).append("\n"); 
		query.append("TO_CHAR(CH.UPD_DT, 'YYYYMMDDHH24MISS') AS UPD_DT," ).append("\n"); 
		query.append("CH.COP_SUB_STS_CD" ).append("\n"); 
		query.append("FROM SCE_COP_HDR CH," ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT BBK.BKG_NO," ).append("\n"); 
		query.append("BBK.BKG_STS_CD" ).append("\n"); 
		query.append("FROM BKG_BOOKING BBK," ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT FM_BKG_NO -- SPLIT 하기 전 원 BOOKING NO" ).append("\n"); 
		query.append("FROM BKG_BOOKING" ).append("\n"); 
		query.append("WHERE BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("AND BKG_CRE_TP_CD = 'S' -- SPLIT" ).append("\n"); 
		query.append(") BK" ).append("\n"); 
		query.append("WHERE BBK.BKG_NO = BK.FM_BKG_NO ) BB" ).append("\n"); 
		query.append("WHERE CH.BKG_NO = BB.BKG_NO" ).append("\n"); 
		query.append("#if (${cntr_no} != '')" ).append("\n"); 
		query.append("AND CH.CNTR_NO = @[cntr_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}