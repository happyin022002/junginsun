/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SPCManageDBDAOMultiSpcSlotInfoByVvdOtrCrrCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.13
*@LastModifier : 남궁진호
*@LastVersion : 1.0
* 2009.10.13 남궁진호
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bsa.bsamanage.spcmanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author NAMKOONG Jin Ho
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SPCManageDBDAOMultiSpcSlotInfoByVvdOtrCrrCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * BSA만 creation시에 생성되며 다른 operation job code에 대해서는 insert해야 하므로 merge into를 사용
	  * bsa_vvd_crr_perf 테이블에 데이터를 입력/수정한다.
	  * </pre>
	  */
	public SPCManageDBDAOMultiSpcSlotInfoByVvdOtrCrrCSQL(){
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
		params.put("bsa_op_jb_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("spc_ctrl_slt_capa",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("crr_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("crr_bsa_capa",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bsa.bsamanage.spcmanage.integration").append("\n"); 
		query.append("FileName : SPCManageDBDAOMultiSpcSlotInfoByVvdOtrCrrCSQL").append("\n"); 
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
		query.append("MERGE INTO BSA_VVD_OTR_CRR A" ).append("\n"); 
		query.append("USING(" ).append("\n"); 
		query.append("SELECT @[trd_cd] AS TRD_CD," ).append("\n"); 
		query.append("@[rlane_cd] AS RLANE_CD," ).append("\n"); 
		query.append("@[vsl_cd] AS VSL_CD," ).append("\n"); 
		query.append("@[skd_voy_no] AS SKD_VOY_NO," ).append("\n"); 
		query.append("@[skd_dir_cd] AS SKD_DIR_CD," ).append("\n"); 
		query.append("@[bsa_op_jb_cd] AS BSA_OP_JB_CD," ).append("\n"); 
		query.append("@[crr_cd] AS CRR_CD," ).append("\n"); 
		query.append("@[crr_bsa_capa] AS CRR_BSA_CAPA," ).append("\n"); 
		query.append("@[spc_ctrl_slt_capa] AS SPC_CTRL_SLT_CAPA," ).append("\n"); 
		query.append("@[cre_usr_id] AS USR_ID" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 
		query.append(") B" ).append("\n"); 
		query.append("ON(" ).append("\n"); 
		query.append("A.TRD_CD         = B.TRD_CD" ).append("\n"); 
		query.append("AND A.RLANE_CD       = B.RLANE_CD" ).append("\n"); 
		query.append("AND A.VSL_CD         = B.VSL_CD" ).append("\n"); 
		query.append("AND A.SKD_VOY_NO     = B.SKD_VOY_NO" ).append("\n"); 
		query.append("AND A.SKD_DIR_CD     = B.SKD_DIR_CD" ).append("\n"); 
		query.append("AND A.BSA_OP_JB_CD   = B.BSA_OP_JB_CD" ).append("\n"); 
		query.append("AND A.CRR_CD         = B.CRR_CD" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("WHEN MATCHED THEN" ).append("\n"); 
		query.append("UPDATE SET" ).append("\n"); 
		query.append("CRR_BSA_CAPA       = B.CRR_BSA_CAPA," ).append("\n"); 
		query.append("SPC_CTRL_SLT_CAPA  = B.SPC_CTRL_SLT_CAPA," ).append("\n"); 
		query.append("UPD_USR_ID         = B.USR_ID," ).append("\n"); 
		query.append("UPD_DT             = SYSDATE" ).append("\n"); 
		query.append("WHEN NOT MATCHED THEN" ).append("\n"); 
		query.append("INSERT (TRD_CD, RLANE_CD, VSL_CD, SKD_VOY_NO, SKD_DIR_CD," ).append("\n"); 
		query.append("BSA_OP_JB_CD, CRR_CD, CRR_BSA_CAPA, SPC_CTRL_SLT_CAPA," ).append("\n"); 
		query.append("CRE_USR_ID, CRE_DT, UPD_USR_ID, UPD_DT)" ).append("\n"); 
		query.append("VALUES(B.TRD_CD, B.RLANE_CD, B.VSL_CD, B.SKD_VOY_NO, B.SKD_DIR_CD," ).append("\n"); 
		query.append("B.BSA_OP_JB_CD, B.CRR_CD, B.CRR_BSA_CAPA, B.SPC_CTRL_SLT_CAPA, B.USR_ID, SYSDATE,B.USR_ID,SYSDATE)" ).append("\n"); 
		query.append("" ).append("\n"); 

	}
}