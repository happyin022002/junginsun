/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : Eur24ManifestDownloadDBDAOModifyBlCustCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.01.06
*@LastModifier : 김경섭
*@LastVersion : 1.0
* 2011.01.06 김경섭
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.eur24.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Kim Gyoung Sub
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class Eur24ManifestDownloadDBDAOModifyBlCustCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * BKG_CSTMS_EUR_CUST table에 정보 삽입
	  * </pre>
	  */
	public Eur24ManifestDownloadDBDAOModifyBlCustCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_cust_addr",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_cust_zip_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_cust_cty_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("c_cust_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_cust_cty_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_cust_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cstms_port_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("n_eori_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_eori_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("c_cstms_decl_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("c_eur_cstms_st_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_cust_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_cstms_decl_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("c_cust_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("c_cust_zip_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("n_cust_zip_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("c_cust_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bl_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_eur_cstms_st_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("n_cust_cty_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_cust_zip_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_cust_addr",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_eori_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_cust_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_cust_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("c_cust_cty_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("n_cust_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("c_cust_addr",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vvd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("n_cust_addr",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("n_cstms_decl_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("n_cust_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("n_cust_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_cstms_decl_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_cust_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("c_eori_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_eur_cstms_st_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("n_eur_cstms_st_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_cust_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.eur24.integration").append("\n"); 
		query.append("FileName : Eur24ManifestDownloadDBDAOModifyBlCustCSQL").append("\n"); 
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
		query.append("BEGIN" ).append("\n"); 
		query.append("#if (${s_ibflag} == 'U')" ).append("\n"); 
		query.append("UPDATE BKG_CSTMS_EUR_CUST" ).append("\n"); 
		query.append("SET " ).append("\n"); 
		query.append("    CUST_NM = @[s_cust_nm], " ).append("\n"); 
		query.append("    CUST_ADDR = @[s_cust_addr], " ).append("\n"); 
		query.append("    CUST_CTY_NM = BKG_SPCLCHAR_CONV_FNC(@[s_cust_cty_nm],'X'), " ).append("\n"); 
		query.append("    EUR_CSTMS_ST_NM = BKG_SPCLCHAR_CONV_FNC(@[s_eur_cstms_st_nm],'X'), " ).append("\n"); 
		query.append("    EORI_NO = @[s_eori_no]," ).append("\n"); 
		query.append("    UPD_DT = SYSDATE, " ).append("\n"); 
		query.append("    CSTMS_DECL_CNT_CD = @[s_cstms_decl_cnt_cd], " ).append("\n"); 
		query.append("    CUST_ZIP_ID = BKG_SPCLCHAR_CONV_FNC(@[s_cust_zip_id],'X')," ).append("\n"); 
		query.append("	CUST_CNT_CD = @[s_cust_cnt_cd]," ).append("\n"); 
		query.append("	CUST_SEQ = @[s_cust_seq]" ).append("\n"); 
		query.append("WHERE VSL_CD||SKD_VOY_NO||SKD_DIR_CD = @[vvd]" ).append("\n"); 
		query.append("  AND BL_NO = @[bl_no]" ).append("\n"); 
		query.append("  AND CSTMS_PORT_CD = @[cstms_port_cd]" ).append("\n"); 
		query.append("  AND BKG_CUST_TP_CD = 'S';" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${f_ibflag} == 'U')" ).append("\n"); 
		query.append("UPDATE BKG_CSTMS_EUR_CUST" ).append("\n"); 
		query.append("SET " ).append("\n"); 
		query.append("    CUST_NM = @[f_cust_nm], " ).append("\n"); 
		query.append("    CUST_ADDR = @[f_cust_addr], " ).append("\n"); 
		query.append("    CUST_CTY_NM = BKG_SPCLCHAR_CONV_FNC(@[f_cust_cty_nm],'X'), " ).append("\n"); 
		query.append("    EUR_CSTMS_ST_NM = BKG_SPCLCHAR_CONV_FNC(@[f_eur_cstms_st_nm],'X'), " ).append("\n"); 
		query.append("    EORI_NO = @[f_eori_no]," ).append("\n"); 
		query.append("    UPD_DT = SYSDATE, " ).append("\n"); 
		query.append("    CSTMS_DECL_CNT_CD = @[f_cstms_decl_cnt_cd], " ).append("\n"); 
		query.append("    CUST_ZIP_ID = BKG_SPCLCHAR_CONV_FNC(@[f_cust_zip_id],'X')," ).append("\n"); 
		query.append("	CUST_CNT_CD = @[f_cust_cnt_cd]," ).append("\n"); 
		query.append("	CUST_SEQ = @[f_cust_seq]" ).append("\n"); 
		query.append("WHERE VSL_CD||SKD_VOY_NO||SKD_DIR_CD = @[vvd]" ).append("\n"); 
		query.append("  AND BL_NO = @[bl_no]" ).append("\n"); 
		query.append("  AND CSTMS_PORT_CD = @[cstms_port_cd]" ).append("\n"); 
		query.append("  AND BKG_CUST_TP_CD = 'F';" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${c_ibflag} == 'U')" ).append("\n"); 
		query.append("UPDATE BKG_CSTMS_EUR_CUST" ).append("\n"); 
		query.append("SET " ).append("\n"); 
		query.append("    CUST_NM = @[c_cust_nm], " ).append("\n"); 
		query.append("    CUST_ADDR = @[c_cust_addr], " ).append("\n"); 
		query.append("    CUST_CTY_NM = BKG_SPCLCHAR_CONV_FNC(@[c_cust_cty_nm],'X'), " ).append("\n"); 
		query.append("    EUR_CSTMS_ST_NM = BKG_SPCLCHAR_CONV_FNC(@[c_eur_cstms_st_nm],'X'), " ).append("\n"); 
		query.append("    EORI_NO = @[c_eori_no]," ).append("\n"); 
		query.append("    UPD_DT = SYSDATE, " ).append("\n"); 
		query.append("    CSTMS_DECL_CNT_CD = @[c_cstms_decl_cnt_cd], " ).append("\n"); 
		query.append("    CUST_ZIP_ID = BKG_SPCLCHAR_CONV_FNC(@[c_cust_zip_id],'X')," ).append("\n"); 
		query.append("	CUST_CNT_CD = @[c_cust_cnt_cd]," ).append("\n"); 
		query.append("	CUST_SEQ = @[c_cust_seq]" ).append("\n"); 
		query.append("WHERE VSL_CD||SKD_VOY_NO||SKD_DIR_CD = @[vvd]" ).append("\n"); 
		query.append("  AND BL_NO = @[bl_no]" ).append("\n"); 
		query.append("  AND CSTMS_PORT_CD = @[cstms_port_cd]" ).append("\n"); 
		query.append("  AND BKG_CUST_TP_CD = 'C';" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${n_ibflag} == 'U')" ).append("\n"); 
		query.append("UPDATE BKG_CSTMS_EUR_CUST" ).append("\n"); 
		query.append("SET " ).append("\n"); 
		query.append("    CUST_NM = @[n_cust_nm], " ).append("\n"); 
		query.append("    CUST_ADDR = @[n_cust_addr], " ).append("\n"); 
		query.append("    CUST_CTY_NM = BKG_SPCLCHAR_CONV_FNC(@[n_cust_cty_nm],'X'), " ).append("\n"); 
		query.append("    EUR_CSTMS_ST_NM = BKG_SPCLCHAR_CONV_FNC(@[n_eur_cstms_st_nm],'X'), " ).append("\n"); 
		query.append("    EORI_NO = @[n_eori_no]," ).append("\n"); 
		query.append("    UPD_DT = SYSDATE, " ).append("\n"); 
		query.append("    CSTMS_DECL_CNT_CD = @[n_cstms_decl_cnt_cd], " ).append("\n"); 
		query.append("    CUST_ZIP_ID = BKG_SPCLCHAR_CONV_FNC(@[n_cust_zip_id],'X')," ).append("\n"); 
		query.append("	CUST_CNT_CD = @[n_cust_cnt_cd]," ).append("\n"); 
		query.append("	CUST_SEQ = @[n_cust_seq]" ).append("\n"); 
		query.append("WHERE VSL_CD||SKD_VOY_NO||SKD_DIR_CD = @[vvd]" ).append("\n"); 
		query.append("  AND BL_NO = @[bl_no]" ).append("\n"); 
		query.append("  AND CSTMS_PORT_CD = @[cstms_port_cd]" ).append("\n"); 
		query.append("  AND BKG_CUST_TP_CD = 'N';" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(" EXCEPTION WHEN VALUE_ERROR THEN ROLLBACK;" ).append("\n"); 
		query.append(" WHEN OTHERS THEN ROLLBACK;" ).append("\n"); 
		query.append(" COMMIT;" ).append("\n"); 
		query.append(" END;" ).append("\n"); 

	}
}