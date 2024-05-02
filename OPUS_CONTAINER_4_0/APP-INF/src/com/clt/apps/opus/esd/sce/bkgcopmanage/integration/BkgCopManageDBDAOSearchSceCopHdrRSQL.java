/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : BkgCopManageDBDAOSearchSceCopHdrRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.06.30
*@LastModifier : 
*@LastVersion : 1.0
* 2015.06.30 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.sce.bkgcopmanage.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BkgCopManageDBDAOSearchSceCopHdrRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * BkgCopManageDBDAOSearchSceCopHdr
	  * </pre>
	  */
	public BkgCopManageDBDAOSearchSceCopHdrRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cop_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.sce.bkgcopmanage.integration ").append("\n"); 
		query.append("FileName : BkgCopManageDBDAOSearchSceCopHdrRSQL").append("\n"); 
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
		query.append("select COP_NO" ).append("\n"); 
		query.append("      ,BKG_NO" ).append("\n"); 
		query.append("      ,CNTR_NO" ).append("\n"); 
		query.append("      ,CNTR_TPSZ_CD" ).append("\n"); 
		query.append("      ,CNMV_YR" ).append("\n"); 
		query.append("      ,COP_STS_CD" ).append("\n"); 
		query.append("      ,PCTL_NO" ).append("\n"); 
		query.append("      ,MST_COP_NO" ).append("\n"); 
		query.append("      ,TO_CHAR(COP_FSH_DT, 'YYYYMMDDHH24MISS') AS COP_FSH_DT" ).append("\n"); 
		query.append("      ,TRNK_VSL_CD" ).append("\n"); 
		query.append("      ,TRNK_SKD_VOY_NO" ).append("\n"); 
		query.append("      ,TRNK_SKD_DIR_CD" ).append("\n"); 
		query.append("      ,POR_NOD_CD" ).append("\n"); 
		query.append("      ,POL_NOD_CD" ).append("\n"); 
		query.append("      ,POD_NOD_CD" ).append("\n"); 
		query.append("      ,DEL_NOD_CD" ).append("\n"); 
		query.append("      ,COP_RAIL_CHK_CD" ).append("\n"); 
		query.append("      ,IB_TRO_FLG" ).append("\n"); 
		query.append("      ,OB_TRO_FLG" ).append("\n"); 
		query.append("      ,RAIL_RCV_COFF_DT_SRC_TP_CD" ).append("\n"); 
		query.append("      ,TO_CHAR(RAIL_RCV_COFF_FM_DT, 'YYYYMMDDHH24MISS') AS RAIL_RCV_COFF_FM_DT" ).append("\n"); 
		query.append("      ,TO_CHAR(RAIL_RCV_COFF_TO_DT, 'YYYYMMDDHH24MISS') AS RAIL_RCV_COFF_TO_DT" ).append("\n"); 
		query.append("      ,CRE_USR_ID" ).append("\n"); 
		query.append("      ,TO_CHAR(CRE_DT, 'YYYYMMDDHH24MISS') AS CRE_DT" ).append("\n"); 
		query.append("      ,UPD_USR_ID" ).append("\n"); 
		query.append("      ,TO_CHAR(UPD_DT, 'YYYYMMDDHH24MISS') AS UPD_DT" ).append("\n"); 
		query.append("  from sce_cop_hdr" ).append("\n"); 
		query.append(" where cop_no = @[cop_no]" ).append("\n"); 

	}
}