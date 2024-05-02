/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SPCManageDBDAOModifymultiSpcSlotInfoByVvdOtrCrrUSQL.java
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

public class SPCManageDBDAOModifymultiSpcSlotInfoByVvdOtrCrrUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * BSA, Weight Per TEU가 변경되었을때 TTL Weight의 값도 변경시켜준다.
	  * </pre>
	  */
	public SPCManageDBDAOModifymultiSpcSlotInfoByVvdOtrCrrUSQL(){
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
		query.append("FileName : SPCManageDBDAOModifymultiSpcSlotInfoByVvdOtrCrrUSQL").append("\n"); 
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
		query.append("SET (X.CRR_BSA_CAPA, X.SPC_CTRL_SLT_CAPA) = (" ).append("\n"); 
		query.append("SELECT NVL(SUM(DECODE(A.BSA_OP_JB_CD, '007', A.CRR_BSA_CAPA)),0)" ).append("\n"); 
		query.append("* NVL(SUM(DECODE(A.BSA_OP_JB_CD, '008', A.CRR_BSA_CAPA)),0) CRR_BSA_CAPA," ).append("\n"); 
		query.append("NVL(SUM(DECODE(A.BSA_OP_JB_CD, '007', A.SPC_CTRL_SLT_CAPA)),0)" ).append("\n"); 
		query.append("* NVL(SUM(DECODE(A.BSA_OP_JB_CD, '008', A.CRR_BSA_CAPA)),0) SPC_CTRL_SLT_CAPA" ).append("\n"); 
		query.append("FROM BSA_VVD_OTR_CRR A" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND A.TRD_CD     = X.TRD_CD" ).append("\n"); 
		query.append("AND A.RLANE_CD   = X.RLANE_CD" ).append("\n"); 
		query.append("AND A.VSL_CD     = X.VSL_CD" ).append("\n"); 
		query.append("AND A.SKD_VOY_NO = X.SKD_VOY_NO" ).append("\n"); 
		query.append("AND A.SKD_DIR_CD = X.SKD_DIR_CD" ).append("\n"); 
		query.append("AND A.CRR_CD     = X.CRR_CD" ).append("\n"); 
		query.append("AND A.TRD_CD     = @[trd_cd]" ).append("\n"); 
		query.append("AND A.RLANE_CD   = @[rlane_cd]" ).append("\n"); 
		query.append("AND A.VSL_CD     = @[vsl_cd]" ).append("\n"); 
		query.append("AND A.SKD_VOY_NO = @[skd_voy_no]" ).append("\n"); 
		query.append("AND A.SKD_DIR_CD = @[skd_dir_cd]" ).append("\n"); 
		query.append("AND A.BSA_OP_JB_CD IN ('007','008')" ).append("\n"); 
		query.append("GROUP BY A.TRD_CD, A.RLANE_CD, A.VSL_CD, A.SKD_VOY_NO, A.SKD_DIR_CD, A.CRR_CD" ).append("\n"); 
		query.append("HAVING NVL(SUM(DECODE(A.BSA_OP_JB_CD, '007', A.CRR_BSA_CAPA)),0) > 0" ).append("\n"); 
		query.append("AND NVL(SUM(DECODE(A.BSA_OP_JB_CD, '008', A.CRR_BSA_CAPA)),0) > 0" ).append("\n"); 
		query.append("AND NVL(SUM(DECODE(A.BSA_OP_JB_CD, '007', A.SPC_CTRL_SLT_CAPA)),0) >0" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("WHERE X.TRD_CD       = @[trd_cd]" ).append("\n"); 
		query.append("AND X.RLANE_CD     = @[rlane_cd]" ).append("\n"); 
		query.append("AND X.VSL_CD       = @[vsl_cd]" ).append("\n"); 
		query.append("AND X.SKD_VOY_NO   = @[skd_voy_no]" ).append("\n"); 
		query.append("AND X.SKD_DIR_CD   = @[skd_dir_cd]" ).append("\n"); 
		query.append("AND X.BSA_OP_JB_CD = '009'" ).append("\n"); 

	}
}