/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : PerformanceReportDBDAOBkgTblColVORSQL.java
*@FileTitle : booking report
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.04
*@LastModifier : 강동윤
*@LastVersion : 1.0
* 2009.06.04 강동윤
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author kang dong yun
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PerformanceReportDBDAOBkgTblColVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * report datail search
	  * </pre>
	  */
	public PerformanceReportDBDAOBkgTblColVORSQL(){
		setQuery();
		
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_rpt_knd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rpt_id",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("SELECT" ).append("\n"); 
		query.append("A.TBL_NM" ).append("\n"); 
		query.append(",	A.COL_NM" ).append("\n"); 
		query.append(",	A.STS_RPT_FLG" ).append("\n"); 
		query.append(",	A.CA_RPT_FLG" ).append("\n"); 
		query.append(",	A.VIP_RPT_FLG" ).append("\n"); 
		query.append(",	A.HIS_CATE_NM" ).append("\n"); 
		query.append(",	A.TBL_COL_NM" ).append("\n"); 
		query.append(",	A.DP_NM" ).append("\n"); 
		query.append(",	A.SQL_CTNT" ).append("\n"); 
		query.append(",	A.HIS_FLG" ).append("\n"); 
		query.append(",	A.CA_EXPT_FLG" ).append("\n"); 
		query.append(",	A.CA_REV_FLG" ).append("\n"); 
		query.append(",	A.CA_COST_FLG" ).append("\n"); 
		query.append(",	A.INV_IF_FLG" ).append("\n"); 
		query.append(",	A.COP_IF_FLG" ).append("\n"); 
		query.append(",	A.COA_IF_FLG" ).append("\n"); 
		query.append(",	A.UPD_GRP_CD" ).append("\n"); 
		query.append(",	A.UPD_SUB_GRP_CD" ).append("\n"); 
		query.append(",	A.CRE_USR_ID" ).append("\n"); 
		query.append(",	A.CRE_DT" ).append("\n"); 
		query.append(",	A.UPD_USR_ID" ).append("\n"); 
		query.append(",	A.UPD_DT" ).append("\n"); 
		query.append(",	B.RPT_ID" ).append("\n"); 
		query.append(",	B.BKG_RPT_KND_CD" ).append("\n"); 
		query.append(",	B.ORD_SEQ" ).append("\n"); 
		query.append("FROM BKG_TBL_COL  		A" ).append("\n"); 
		query.append(",BKG_RPT_DFLT_DTL 	B" ).append("\n"); 
		query.append("WHERE A.TBL_NM = B.TBL_NM" ).append("\n"); 
		query.append("AND A.COL_NM = B.COL_NM" ).append("\n"); 
		query.append("AND B.RPT_ID = @[rpt_id]" ).append("\n"); 
		query.append("AND B.BKG_RPT_KND_CD = @[bkg_rpt_knd_cd]" ).append("\n"); 

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.nis2010.esm.bkg.bookingreport.performancereport.integration ").append("\n"); 
		query.append("FileName : PerformanceReportDBDAOBkgTblColVORSQL").append("\n"); 
		query.append("*/").append("\n"); 
	}
}