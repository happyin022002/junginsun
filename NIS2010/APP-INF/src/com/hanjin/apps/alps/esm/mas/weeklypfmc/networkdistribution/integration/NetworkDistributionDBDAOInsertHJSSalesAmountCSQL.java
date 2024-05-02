/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : NetworkDistributionDBDAOInsertHJSSalesAmountCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.08.14
*@LastModifier : 
*@LastVersion : 1.0
* 2017.08.14 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.mas.weeklypfmc.networkdistribution.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class NetworkDistributionDBDAOInsertHJSSalesAmountCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * MAS_VVD_HIR 테이블에 STND_COST_CD 없는 ROW INSERT
	  * </pre>
	  */
	public NetworkDistributionDBDAOInsertHJSSalesAmountCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dir_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("ioc_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("trd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("skd_voy_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.mas.weeklypfmc.networkdistribution.integration").append("\n"); 
		query.append("FileName : NetworkDistributionDBDAOInsertHJSSalesAmountCSQL").append("\n"); 
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
		query.append("INSERT	INTO	MAS_VVD_HIR" ).append("\n"); 
		query.append("				(" ).append("\n"); 
		query.append("					TRD_CD," ).append("\n"); 
		query.append("					RLANE_CD," ).append("\n"); 
		query.append("					IOC_CD," ).append("\n"); 
		query.append("					VSL_CD," ).append("\n"); 
		query.append("					SKD_VOY_NO," ).append("\n"); 
		query.append("					DIR_CD," ).append("\n"); 
		query.append("					STND_COST_CD," ).append("\n"); 
		query.append("					CRE_USR_ID," ).append("\n"); 
		query.append("					CRE_DT," ).append("\n"); 
		query.append("					UPD_USR_ID," ).append("\n"); 
		query.append("					UPD_DT)" ).append("\n"); 
		query.append("SELECT	*" ).append("\n"); 
		query.append("FROM	(" ).append("\n"); 
		query.append("			SELECT	@[trd_cd]		AS	TRD_CD,			-- amt_1_01 컬럼" ).append("\n"); 
		query.append("					@[rlane_cd]		AS	RLANE_CD," ).append("\n"); 
		query.append("					@[ioc_cd]		AS	IOC_CD, " ).append("\n"); 
		query.append("					@[vsl_cd]		AS	VSL_CD," ).append("\n"); 
		query.append("					@[skd_voy_no]	AS	SKD_VOY_NO," ).append("\n"); 
		query.append("					@[dir_cd]		AS	DIR_CD," ).append("\n"); 
		query.append("					'53101000'		AS	STND_COST_CD," ).append("\n"); 
		query.append("					@[cre_usr_id]	AS	CRE_USR_ID," ).append("\n"); 
		query.append("					SYSDATE			AS	CRE_DT," ).append("\n"); 
		query.append("					@[upd_usr_id]	AS	UPD_USR_ID," ).append("\n"); 
		query.append("					SYSDATE			AS	UPD_DT" ).append("\n"); 
		query.append("			FROM	DUAL" ).append("\n"); 
		query.append("			UNION" ).append("\n"); 
		query.append("			SELECT	@[trd_cd]		AS	TRD_CD,			-- amt_1_02 컬럼" ).append("\n"); 
		query.append("					@[rlane_cd]		AS	RLANE_CD," ).append("\n"); 
		query.append("					@[ioc_cd]		AS	IOC_CD," ).append("\n"); 
		query.append("					@[vsl_cd]		AS	VSL_CD," ).append("\n"); 
		query.append("					@[skd_voy_no]	AS	SKD_VOY_NO," ).append("\n"); 
		query.append("					@[dir_cd]		AS	DIR_CD," ).append("\n"); 
		query.append("					'53102000'		AS	STND_COST_CD," ).append("\n"); 
		query.append("					@[cre_usr_id]	AS	CRE_USR_ID," ).append("\n"); 
		query.append("					SYSDATE			AS	CRE_DT," ).append("\n"); 
		query.append("					@[upd_usr_id]	AS	UPD_USR_ID," ).append("\n"); 
		query.append("					SYSDATE			AS	UPD_DT" ).append("\n"); 
		query.append("			FROM	DUAL" ).append("\n"); 
		query.append("			UNION" ).append("\n"); 
		query.append("			SELECT	@[trd_cd]		AS	TRD_CD,			-- amt_1_03 컬럼" ).append("\n"); 
		query.append("					@[rlane_cd]		AS	RLANE_CD," ).append("\n"); 
		query.append("					@[ioc_cd]		AS	IOC_CD," ).append("\n"); 
		query.append("					@[vsl_cd]		As	VSL_CD," ).append("\n"); 
		query.append("					@[skd_voy_no]	AS	SKD_VOY_NO," ).append("\n"); 
		query.append("					@[dir_cd]		AS	DIR_CD," ).append("\n"); 
		query.append("					'53200000'		AS	STND_COST_CD," ).append("\n"); 
		query.append("					@[cre_usr_id]	AS	CRE_USR_ID," ).append("\n"); 
		query.append("					SYSDATE			AS	CRE_DT," ).append("\n"); 
		query.append("					@[upd_usr_id]	AS	UPD_USR_ID," ).append("\n"); 
		query.append("					SYSDATE			AS	UPD_DT" ).append("\n"); 
		query.append("			FROM	DUAL" ).append("\n"); 
		query.append("			UNION" ).append("\n"); 
		query.append("			SELECT	@[trd_cd]		AS	TRD_CD,			-- amt_1_04 컬럼" ).append("\n"); 
		query.append("					@[rlane_cd]		AS	RLANE_CD," ).append("\n"); 
		query.append("					@[ioc_cd]		AS	IOC_CD," ).append("\n"); 
		query.append("					@[vsl_cd]		AS	VSL_CD," ).append("\n"); 
		query.append("					@[skd_voy_no]	AS	SKD_VOY_NO," ).append("\n"); 
		query.append("					@[dir_cd]		AS	DIR_CD," ).append("\n"); 
		query.append("					'54100000'		AS	STND_COST_CD," ).append("\n"); 
		query.append("					@[cre_usr_id]	AS	CRE_USR_ID," ).append("\n"); 
		query.append("					SYSDATE			AS	CRE_DT," ).append("\n"); 
		query.append("					@[upd_usr_id]	AS	UPD_USR_ID," ).append("\n"); 
		query.append("					SYSDATE			AS	UPD_DT" ).append("\n"); 
		query.append("			FROM	DUAL" ).append("\n"); 
		query.append("    		UNION" ).append("\n"); 
		query.append("    		SELECT	@[trd_cd]		AS	TRD_CD,			-- amt_1_05 컬럼" ).append("\n"); 
		query.append("					@[rlane_cd]		AS	RLANE_CD," ).append("\n"); 
		query.append("					@[ioc_cd]		AS	IOC_CD," ).append("\n"); 
		query.append("					@[vsl_cd]		AS	VSL_CD," ).append("\n"); 
		query.append("					@[skd_voy_no]	AS	SKD_VOY_NO," ).append("\n"); 
		query.append("					@[dir_cd]		AS	DIR_CD," ).append("\n"); 
		query.append("					'54250000'		AS	STND_COST_CD," ).append("\n"); 
		query.append("					@[cre_usr_id]	AS	CRE_USR_ID," ).append("\n"); 
		query.append("					SYSDATE			AS	CRE_DT," ).append("\n"); 
		query.append("					@[upd_usr_id]	AS	UPD_USR_ID," ).append("\n"); 
		query.append("					SYSDATE			AS	UPD_DT" ).append("\n"); 
		query.append("			FROM	DUAL" ).append("\n"); 
		query.append("    		UNION" ).append("\n"); 
		query.append("    		SELECT	@[trd_cd]		AS	TRD_CD,			-- amt_1_06 컬럼" ).append("\n"); 
		query.append("					@[rlane_cd]		AS	RLANE_CD," ).append("\n"); 
		query.append("					@[ioc_cd]		AS	IOC_CD," ).append("\n"); 
		query.append("					@[vsl_cd]		AS	VSL_CD," ).append("\n"); 
		query.append("					@[skd_voy_no]	AS	SKD_VOY_NO," ).append("\n"); 
		query.append("					@[dir_cd]		AS	DIR_CD," ).append("\n"); 
		query.append("					'54300000'		AS	STND_COST_CD," ).append("\n"); 
		query.append("					@[cre_usr_id]	AS	CRE_USR_ID," ).append("\n"); 
		query.append("					SYSDATE			AS	CRE_DT," ).append("\n"); 
		query.append("					@[upd_usr_id]	AS	UPD_USR_ID," ).append("\n"); 
		query.append("					SYSDATE			AS	UPD_DT" ).append("\n"); 
		query.append("			FROM	DUAL" ).append("\n"); 
		query.append("    		UNION" ).append("\n"); 
		query.append("    		SELECT	@[trd_cd]		AS	TRD_CD,			-- amt_1_07 컬럼" ).append("\n"); 
		query.append("					@[rlane_cd]		AS	RLANE_CD," ).append("\n"); 
		query.append("					@[ioc_cd]		AS	IOC_CD," ).append("\n"); 
		query.append("					@[vsl_cd]		AS	VSL_CD," ).append("\n"); 
		query.append("					@[skd_voy_no]	AS	SKD_VOY_NO," ).append("\n"); 
		query.append("					@[dir_cd]		AS	DIR_CD," ).append("\n"); 
		query.append("					'54200000'		AS	STND_COST_CD," ).append("\n"); 
		query.append("					@[cre_usr_id]	AS	CRE_USR_ID," ).append("\n"); 
		query.append("					SYSDATE			AS	CRE_DT," ).append("\n"); 
		query.append("					@[upd_usr_id]	AS	UPD_USR_ID," ).append("\n"); 
		query.append("					SYSDATE			AS	UPD_DT" ).append("\n"); 
		query.append("			FROM	DUAL" ).append("\n"); 
		query.append("    		UNION" ).append("\n"); 
		query.append("    		SELECT	@[trd_cd]		AS	TRD_CD,			-- amt_1_08 컬럼" ).append("\n"); 
		query.append("					@[rlane_cd]		AS	RLANE_CD," ).append("\n"); 
		query.append("					@[ioc_cd]		AS	IOC_CD," ).append("\n"); 
		query.append("					@[vsl_cd]		AS	VSL_CD," ).append("\n"); 
		query.append("					@[skd_voy_no]	AS	SKD_VOY_NO," ).append("\n"); 
		query.append("					@[dir_cd]		AS	DIR_CD," ).append("\n"); 
		query.append("					'54150000'		AS	STND_COST_CD," ).append("\n"); 
		query.append("					@[cre_usr_id]	AS	CRE_USR_ID," ).append("\n"); 
		query.append("					SYSDATE			AS	CRE_DT," ).append("\n"); 
		query.append("					@[upd_usr_id]	AS	UPD_USR_ID," ).append("\n"); 
		query.append("					SYSDATE			AS	UPD_DT" ).append("\n"); 
		query.append("			FROM	DUAL" ).append("\n"); 
		query.append("    		UNION" ).append("\n"); 
		query.append("    		SELECT	@[trd_cd]		AS	TRD_CD,			-- amt_1_09 컬럼" ).append("\n"); 
		query.append("					@[rlane_cd]		AS	RLANE_CD," ).append("\n"); 
		query.append("					@[ioc_cd]		AS	IOC_CD," ).append("\n"); 
		query.append("					@[vsl_cd]		AS	VSL_CD," ).append("\n"); 
		query.append("					@[skd_voy_no]	AS	SKD_VOY_NO," ).append("\n"); 
		query.append("					@[dir_cd]		AS	DIR_CD," ).append("\n"); 
		query.append("					'54450000'		AS	STND_COST_CD," ).append("\n"); 
		query.append("					@[cre_usr_id]	AS	CRE_USR_ID," ).append("\n"); 
		query.append("					SYSDATE			AS	CRE_DT," ).append("\n"); 
		query.append("					@[upd_usr_id]	AS	UPD_USR_ID," ).append("\n"); 
		query.append("					SYSDATE			AS	UPD_DT" ).append("\n"); 
		query.append("			FROM	DUAL" ).append("\n"); 
		query.append("    		UNION" ).append("\n"); 
		query.append("    		SELECT	@[trd_cd]		AS	TRD_CD,			-- amt_1_10 컬럼" ).append("\n"); 
		query.append("					@[rlane_cd]		AS	RLANE_CD," ).append("\n"); 
		query.append("					@[ioc_cd]		AS	IOC_CD," ).append("\n"); 
		query.append("					@[vsl_cd]		AS	VSL_CD," ).append("\n"); 
		query.append("					@[skd_voy_no]	AS	SKD_VOY_NO," ).append("\n"); 
		query.append("					@[dir_cd]		AS	DIR_CD," ).append("\n"); 
		query.append("					'54180000'		AS	STND_COST_CD," ).append("\n"); 
		query.append("					@[cre_usr_id]	AS	CRE_USR_ID," ).append("\n"); 
		query.append("					SYSDATE			AS	CRE_DT," ).append("\n"); 
		query.append("					@[upd_usr_id]	AS	UPD_USR_ID," ).append("\n"); 
		query.append("					SYSDATE			AS	UPD_DT" ).append("\n"); 
		query.append("			FROM	DUAL" ).append("\n"); 
		query.append("    		UNION" ).append("\n"); 
		query.append("    		SELECT	@[trd_cd]		AS	TRD_CD,			-- amt_1_11 컬럼" ).append("\n"); 
		query.append("					@[rlane_cd]		AS	RLANE_CD," ).append("\n"); 
		query.append("					@[ioc_cd]		AS	IOC_CD," ).append("\n"); 
		query.append("					@[vsl_cd]		AS	VSL_CD," ).append("\n"); 
		query.append("					@[skd_voy_no]	AS	SKD_VOY_NO," ).append("\n"); 
		query.append("					@[dir_cd]		AS	DIR_CD," ).append("\n"); 
		query.append("					'54550000'		AS	STND_COST_CD," ).append("\n"); 
		query.append("					@[cre_usr_id]	AS	CRE_USR_ID," ).append("\n"); 
		query.append("					SYSDATE			AS	CRE_DT," ).append("\n"); 
		query.append("					@[upd_usr_id]	AS	UPD_USR_ID," ).append("\n"); 
		query.append("					SYSDATE			AS	UPD_DT" ).append("\n"); 
		query.append("			FROM	DUAL" ).append("\n"); 
		query.append("    		UNION" ).append("\n"); 
		query.append("    		SELECT	@[trd_cd]		AS	TRD_CD,			-- amt_1_12 컬럼" ).append("\n"); 
		query.append("					@[rlane_cd]		AS	RLANE_CD," ).append("\n"); 
		query.append("					@[ioc_cd]		AS	IOC_CD," ).append("\n"); 
		query.append("					@[vsl_cd]		AS	VSL_CD," ).append("\n"); 
		query.append("					@[skd_voy_no]	AS	SKD_VOY_NO," ).append("\n"); 
		query.append("					@[dir_cd]		AS	DIR_CD," ).append("\n"); 
		query.append("					'54350000'		AS	STND_COST_CD," ).append("\n"); 
		query.append("					@[cre_usr_id]	AS	CRE_USR_ID," ).append("\n"); 
		query.append("					SYSDATE			AS	CRE_DT," ).append("\n"); 
		query.append("					@[upd_usr_id]	AS	UPD_USR_ID," ).append("\n"); 
		query.append("					SYSDATE			AS	UPD_DT" ).append("\n"); 
		query.append("			FROM	DUAL" ).append("\n"); 
		query.append("    		UNION" ).append("\n"); 
		query.append("    		SELECT	@[trd_cd]		AS	TRD_CD,			-- amt_1_13 컬럼" ).append("\n"); 
		query.append("					@[rlane_cd]		AS	RLANE_CD," ).append("\n"); 
		query.append("					@[ioc_cd]		AS	IOC_CD," ).append("\n"); 
		query.append("					@[vsl_cd]		AS	VSL_CD," ).append("\n"); 
		query.append("					@[skd_voy_no]	AS	SKD_VOY_NO," ).append("\n"); 
		query.append("					@[dir_cd]		AS	DIR_CD," ).append("\n"); 
		query.append("					'54400000'		AS	STND_COST_CD," ).append("\n"); 
		query.append("					@[cre_usr_id]	AS	CRE_USR_ID," ).append("\n"); 
		query.append("					SYSDATE			AS	CRE_DT," ).append("\n"); 
		query.append("					@[upd_usr_id]	AS	UPD_USR_ID," ).append("\n"); 
		query.append("					SYSDATE			AS	UPD_DT" ).append("\n"); 
		query.append("			FROM	DUAL" ).append("\n"); 
		query.append("    		UNION" ).append("\n"); 
		query.append("    		SELECT	@[trd_cd]		AS	TRD_CD,			-- amt_1_14 컬럼" ).append("\n"); 
		query.append("					@[rlane_cd]		AS	RLANE_CD," ).append("\n"); 
		query.append("					@[ioc_cd]		AS	IOC_CD," ).append("\n"); 
		query.append("					@[vsl_cd]		AS	VSL_CD," ).append("\n"); 
		query.append("					@[skd_voy_no]	AS	SKD_VOY_NO," ).append("\n"); 
		query.append("					@[dir_cd]		AS	DIR_CD," ).append("\n"); 
		query.append("					'72100000'		AS	STND_COST_CD," ).append("\n"); 
		query.append("					@[cre_usr_id]	AS	CRE_USR_ID," ).append("\n"); 
		query.append("					SYSDATE			AS	CRE_DT," ).append("\n"); 
		query.append("					@[upd_usr_id]	AS	UPD_USR_ID," ).append("\n"); 
		query.append("					SYSDATE			AS	UPD_DT" ).append("\n"); 
		query.append("			FROM	DUAL)" ).append("\n"); 
		query.append("WHERE	STND_COST_CD	NOT	IN" ).append("\n"); 
		query.append("		(" ).append("\n"); 
		query.append("			SELECT	STND_COST_CD" ).append("\n"); 
		query.append("			FROM	MAS_VVD_HIR" ).append("\n"); 
		query.append("    		WHERE	1 = 1" ).append("\n"); 
		query.append("    		AND		TRD_CD		= @[trd_cd]" ).append("\n"); 
		query.append("    		AND		RLANE_CD	= @[rlane_cd]" ).append("\n"); 
		query.append("			AND		IOC_CD		= @[ioc_cd]" ).append("\n"); 
		query.append("    		AND		VSL_CD		= @[vsl_cd]" ).append("\n"); 
		query.append("    		AND		SKD_VOY_NO	= @[skd_voy_no]" ).append("\n"); 
		query.append("    		AND		DIR_CD		= @[dir_cd])" ).append("\n"); 

	}
}