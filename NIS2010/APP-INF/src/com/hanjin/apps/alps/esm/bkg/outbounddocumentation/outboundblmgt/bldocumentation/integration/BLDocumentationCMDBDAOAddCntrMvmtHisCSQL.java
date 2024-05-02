/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : BLDocumentationCMDBDAOAddCntrMvmtHisCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.01.25
*@LastModifier : 
*@LastVersion : 1.0
* 2011.01.25 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BLDocumentationCMDBDAOAddCntrMvmtHisCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * AddCntrMvmtHis
	  *  * 2011.01.20 이일민 [CHM-201108410-01] [CSR] Container OC History Table 항목 추가
	  * </pre>
	  */
	public BLDocumentationCMDBDAOAddCntrMvmtHisCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cnmv_yr",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mvmt_sts_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("lstrm_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cnmv_id_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fnd_bkg",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cntr_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cnmv_cyc_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cnmv_evnt_dt",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.integration").append("\n"); 
		query.append("FileName : BLDocumentationCMDBDAOAddCntrMvmtHisCSQL").append("\n"); 
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
		query.append("INSERT INTO BKG_CNTR_MVMT_HIS (" ).append("\n"); 
		query.append("    BKG_NO," ).append("\n"); 
		query.append("    CNTR_NO," ).append("\n"); 
		query.append("    CNMV_SEQ, " ).append("\n"); 
		query.append("    CNMV_YR," ).append("\n"); 
		query.append("	CNMV_ID_NO," ).append("\n"); 
		query.append("	CNMV_CYC_NO," ).append("\n"); 
		query.append("    CNMV_EVNT_DT," ).append("\n"); 
		query.append("	CNMV_STS_CD," ).append("\n"); 
		query.append("	LSTM_CD," ).append("\n"); 
		query.append("	DIFF_RMK," ).append("\n"); 
		query.append("	CRE_USR_ID," ).append("\n"); 
		query.append("	CRE_DT," ).append("\n"); 
		query.append("	UPD_USR_ID," ).append("\n"); 
		query.append("	UPD_DT)" ).append("\n"); 
		query.append("VALUES (" ).append("\n"); 
		query.append("	@[bkg_no]," ).append("\n"); 
		query.append("	@[cntr_no]," ).append("\n"); 
		query.append("	(SELECT NVL(MAX(CNMV_SEQ),0)+1 FROM BKG_CNTR_MVMT_HIS WHERE @[bkg_no] = BKG_NO AND @[cntr_no] = CNTR_NO)," ).append("\n"); 
		query.append("	#if ('M'==${fnd_bkg})" ).append("\n"); 
		query.append("		(SELECT CNMV_YR FROM   BKG_CONTAINER WHERE  @[bkg_no] = BKG_NO AND    @[cntr_no] = CNTR_NO)," ).append("\n"); 
		query.append("		(SELECT CNMV_ID_NO FROM   BKG_CONTAINER WHERE  @[bkg_no] = BKG_NO AND    @[cntr_no] = CNTR_NO)," ).append("\n"); 
		query.append("		(SELECT CNMV_CYC_NO FROM   BKG_CONTAINER WHERE  @[bkg_no] = BKG_NO AND    @[cntr_no] = CNTR_NO)," ).append("\n"); 
		query.append("		TO_DATE(@[cnmv_evnt_dt],'YYYYMMDDHH24MI')," ).append("\n"); 
		query.append("	#else" ).append("\n"); 
		query.append("		@[cnmv_yr]," ).append("\n"); 
		query.append("		@[cnmv_id_no]," ).append("\n"); 
		query.append("		@[cnmv_cyc_no]," ).append("\n"); 
		query.append("		(SELECT CNMV_EVNT_DT FROM CTM_MOVEMENT WHERE @[cntr_no] = CNTR_NO AND @[cnmv_id_no] = CNMV_ID_NO AND @[cnmv_yr] = CNMV_YR AND 1 = ROWNUM)," ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("	@[mvmt_sts_cd]," ).append("\n"); 
		query.append("	@[lstrm_cd]," ).append("\n"); 
		query.append("	@[fnd_bkg],  --diff_rmk" ).append("\n"); 
		query.append("	@[cre_usr_id]," ).append("\n"); 
		query.append("	SYSDATE," ).append("\n"); 
		query.append("	@[upd_usr_id]," ).append("\n"); 
		query.append("	SYSDATE" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}