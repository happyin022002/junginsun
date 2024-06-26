/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : SurchargeGroupCommodityDBDAOPriComGrpCmdtDtlVOCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.07.03
*@LastModifier : 
*@LastVersion : 1.0
* 2015.07.03 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.surcharge.surchargegroupcommodity.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SurchargeGroupCommodityDBDAOPriComGrpCmdtDtlVOCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Surcharge Commodity Group Detail 정보를 생성한다.
	  * 
	  * 2015.07.03 [CHM-201536741] 전지예 Blocking 되어 있는 Non cargo NOS를 User가 화면에서 정정가능하도록 Open   
	  * </pre>
	  */
	public SurchargeGroupCommodityDBDAOPriComGrpCmdtDtlVOCSQL(){
		setQuery();
		
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eff_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("exp_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("non_cgo_nos_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("upd_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("chg_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("scg_grp_cmdt_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cmdt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("svc_scp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("scg_grp_cmdt_dtl_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.pri.surcharge.surchargegroupcommodity.integration").append("\n"); 
		query.append("FileName : SurchargeGroupCommodityDBDAOPriComGrpCmdtDtlVOCSQL").append("\n"); 
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
		query.append("INSERT INTO PRI_SCG_GRP_CMDT_DTL (" ).append("\n"); 
		query.append("     SVC_SCP_CD" ).append("\n"); 
		query.append(",    CHG_CD" ).append("\n"); 
		query.append(",    SCG_GRP_CMDT_SEQ" ).append("\n"); 
		query.append(",    SCG_GRP_CMDT_DTL_SEQ" ).append("\n"); 
		query.append(",    CMDT_CD" ).append("\n"); 
		query.append(",    NON_CGO_NOS_FLG" ).append("\n"); 
		query.append(",    EFF_DT" ).append("\n"); 
		query.append(",    EXP_DT" ).append("\n"); 
		query.append(",    CRE_USR_ID" ).append("\n"); 
		query.append(",    CRE_DT" ).append("\n"); 
		query.append(",    UPD_USR_ID" ).append("\n"); 
		query.append(",    UPD_DT" ).append("\n"); 
		query.append(") VALUES( " ).append("\n"); 
		query.append("     @[svc_scp_cd]" ).append("\n"); 
		query.append(",    @[chg_cd]" ).append("\n"); 
		query.append(",    @[scg_grp_cmdt_seq]" ).append("\n"); 
		query.append(",    @[scg_grp_cmdt_dtl_seq]" ).append("\n"); 
		query.append(",    @[cmdt_cd]" ).append("\n"); 
		query.append(",    DECODE(@[non_cgo_nos_flg],'0','N','1','Y')" ).append("\n"); 
		query.append(",    TO_DATE(@[eff_dt],'YYYY-MM-DD')" ).append("\n"); 
		query.append(",    TO_DATE(@[exp_dt],'YYYY-MM-DD')" ).append("\n"); 
		query.append(",    @[cre_usr_id]" ).append("\n"); 
		query.append(",    SYSDATE" ).append("\n"); 
		query.append(",    @[upd_usr_id]" ).append("\n"); 
		query.append(",    SYSDATE" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}