/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SPCManageDBDAOModifymultiSpcSlotInfoByVvdOtrCrr2USQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.13
*@LastModifier : 남궁진호
*@LastVersion : 1.0
* 2009.10.13 남궁진호
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bsa.bsamanage.spcmanage.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author NAMKOONG Jin Ho
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SPCManageDBDAOModifymultiSpcSlotInfoByVvdOtrCrr2USQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * TTL Weight가 변경되었을때 Weight Per TEU의 값도 변경시켜준다.
	  * </pre>
	  */
	public SPCManageDBDAOModifymultiSpcSlotInfoByVvdOtrCrr2USQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rlane_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trd_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("skd_voy_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bsa.bsamanage.spcmanage.integration ").append("\n"); 
		query.append("FileName : SPCManageDBDAOModifymultiSpcSlotInfoByVvdOtrCrr2USQL").append("\n"); 
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
		query.append("UPDATE BSA_VVD_OTR_CRR X" ).append("\n"); 
		query.append("SET (X.CRR_BSA_CAPA," ).append("\n"); 
		query.append("X.SPC_CTRL_SLT_CAPA) = (" ).append("\n"); 
		query.append("SELECT --Y.TRD_CD, Y.RLANE_CD, Y.VSL_CD, Y.SKD_VOY_NO, Y.SKD_DIR_CD, Y.CRR_CD," ).append("\n"); 
		query.append("DECODE( SUM(DECODE(Y.BSA_OP_JB_CD,'007',NVL(Y.CRR_BSA_CAPA,0))), '0', '0'," ).append("\n"); 
		query.append("SUM(DECODE(Y.BSA_OP_JB_CD,'009',NVL(Y.CRR_BSA_CAPA,0)))/" ).append("\n"); 
		query.append("SUM(DECODE(Y.BSA_OP_JB_CD,'007',NVL(Y.CRR_BSA_CAPA,0))) ) CRR_BSA_CAPA," ).append("\n"); 
		query.append("DECODE( SUM(DECODE(Y.BSA_OP_JB_CD,'007',NVL(Y.SPC_CTRL_SLT_CAPA,0))), '0', '0'," ).append("\n"); 
		query.append("SUM(DECODE(Y.BSA_OP_JB_CD,'009',NVL(Y.CRR_BSA_CAPA,0)))/" ).append("\n"); 
		query.append("SUM(DECODE(Y.BSA_OP_JB_CD,'007',NVL(Y.SPC_CTRL_SLT_CAPA,0))) ) SPC_CTRL_SLT_CAPA" ).append("\n"); 
		query.append("FROM BSA_VVD_OTR_CRR Y" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND X.TRD_CD       = Y.TRD_CD" ).append("\n"); 
		query.append("AND X.RLANE_CD     = Y.RLANE_CD" ).append("\n"); 
		query.append("AND X.VSL_CD       = Y.VSL_CD" ).append("\n"); 
		query.append("AND X.SKD_VOY_NO   = Y.SKD_VOY_NO" ).append("\n"); 
		query.append("AND X.SKD_DIR_CD   = Y.SKD_DIR_CD" ).append("\n"); 
		query.append("AND X.CRR_CD       = Y.CRR_CD" ).append("\n"); 
		query.append("AND Y.BSA_OP_JB_CD IN ('007','009')" ).append("\n"); 
		query.append("--GROUP BY Y.TRD_CD, Y.RLANE_CD, Y.VSL_CD, Y.SKD_VOY_NO, Y.SKD_DIR_CD, Y.CRR_CD" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND X.TRD_CD       = @[trd_cd]" ).append("\n"); 
		query.append("AND X.RLANE_CD     = @[rlane_cd]" ).append("\n"); 
		query.append("AND X.VSL_CD       = @[vsl_cd]" ).append("\n"); 
		query.append("AND X.SKD_VOY_NO   = @[skd_voy_no]" ).append("\n"); 
		query.append("AND X.SKD_DIR_CD   = @[skd_dir_cd]" ).append("\n"); 
		query.append("AND X.BSA_OP_JB_CD = '008'" ).append("\n"); 

	}
}