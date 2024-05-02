/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : Eur24ManifestDownloadDBDAOAddBlCustCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.01.06
*@LastModifier : 김경섭
*@LastVersion : 1.0
* 2011.01.06 김경섭
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.eur24.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Kim Gyoung Sub
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class Eur24ManifestDownloadDBDAOAddBlCustCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * BKG_CSTMS_EUR_CUST table에 데이터 입력
	  * PL/SQL을 사용하여 S, F, N, C일괄 입력 하고 있다.
	  * </pre>
	  */
	public Eur24ManifestDownloadDBDAOAddBlCustCSQL(){
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
		params.put("c_cust_nm",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("upd_usr_id",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("f_cust_seq",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("Path : com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.eur24.integration").append("\n"); 
		query.append("FileName : Eur24ManifestDownloadDBDAOAddBlCustCSQL").append("\n"); 
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
		query.append("#if (${s_ibflag} == 'I')" ).append("\n"); 
		query.append("INSERT" ).append("\n"); 
		query.append("INTO BKG_CSTMS_EUR_CUST( VSL_CD, SKD_VOY_NO, SKD_DIR_CD, CUST_CNT_CD, CUST_SEQ, BL_NO, CSTMS_PORT_CD, BKG_CUST_TP_CD, CUST_NM, CUST_ADDR, CUST_CTY_NM, EUR_CSTMS_ST_NM, EORI_NO,CRE_USR_ID, CRE_DT, UPD_USR_ID, UPD_DT, CSTMS_DECL_CNT_CD, CUST_ZIP_ID)" ).append("\n"); 
		query.append("VALUES( SUBSTR(@[vvd], 1, 4)," ).append("\n"); 
		query.append("      SUBSTR(@[vvd], 5, 4)," ).append("\n"); 
		query.append("      SUBSTR(@[vvd], 9, 1)," ).append("\n"); 
		query.append("	  @[s_cust_cnt_cd]," ).append("\n"); 
		query.append("	  @[s_cust_seq]," ).append("\n"); 
		query.append("      @[bl_no]," ).append("\n"); 
		query.append("      @[cstms_port_cd]," ).append("\n"); 
		query.append("      'S'," ).append("\n"); 
		query.append("      @[s_cust_nm]," ).append("\n"); 
		query.append("      @[s_cust_addr]," ).append("\n"); 
		query.append("      BKG_SPCLCHAR_CONV_FNC(@[s_cust_cty_nm],'X')," ).append("\n"); 
		query.append("      BKG_SPCLCHAR_CONV_FNC(@[s_eur_cstms_st_nm],'X')," ).append("\n"); 
		query.append("      @[s_eori_no]," ).append("\n"); 
		query.append("      @[cre_usr_id]," ).append("\n"); 
		query.append("      sysdate," ).append("\n"); 
		query.append("      @[upd_usr_id]," ).append("\n"); 
		query.append("      sysdate," ).append("\n"); 
		query.append("      @[s_cstms_decl_cnt_cd]," ).append("\n"); 
		query.append("      BKG_SPCLCHAR_CONV_FNC(@[s_cust_zip_id]),'X')" ).append("\n"); 
		query.append("      );" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("SELECT * FROM DUAL;" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${f_ibflag} == 'I')" ).append("\n"); 
		query.append("INSERT" ).append("\n"); 
		query.append("INTO BKG_CSTMS_EUR_CUST( VSL_CD, SKD_VOY_NO, SKD_DIR_CD, CUST_CNT_CD, CUST_SEQ, BL_NO, CSTMS_PORT_CD, BKG_CUST_TP_CD, CUST_NM, CUST_ADDR, CUST_CTY_NM, EUR_CSTMS_ST_NM, EORI_NO, CRE_USR_ID, CRE_DT, UPD_USR_ID, UPD_DT, CSTMS_DECL_CNT_CD, CUST_ZIP_ID)" ).append("\n"); 
		query.append("VALUES( SUBSTR(@[vvd], 1, 4)," ).append("\n"); 
		query.append("      SUBSTR(@[vvd], 5, 4)," ).append("\n"); 
		query.append("      SUBSTR(@[vvd], 9, 1)," ).append("\n"); 
		query.append("	  @[f_cust_cnt_cd]," ).append("\n"); 
		query.append("	  @[f_cust_seq]," ).append("\n"); 
		query.append("      @[bl_no]," ).append("\n"); 
		query.append("      @[cstms_port_cd]," ).append("\n"); 
		query.append("      'F'," ).append("\n"); 
		query.append("      @[f_cust_nm]," ).append("\n"); 
		query.append("      @[f_cust_addr]," ).append("\n"); 
		query.append("      BKG_SPCLCHAR_CONV_FNC(@[f_cust_cty_nm],'X')," ).append("\n"); 
		query.append("      BKG_SPCLCHAR_CONV_FNC(@[f_eur_cstms_st_nm],'X')," ).append("\n"); 
		query.append("      @[f_eori_no]," ).append("\n"); 
		query.append("      @[cre_usr_id]," ).append("\n"); 
		query.append("      sysdate," ).append("\n"); 
		query.append("      @[upd_usr_id]," ).append("\n"); 
		query.append("      sysdate," ).append("\n"); 
		query.append("      @[f_cstms_decl_cnt_cd]," ).append("\n"); 
		query.append("      BKG_SPCLCHAR_CONV_FNC(@[f_cust_zip_id],'X')" ).append("\n"); 
		query.append("      );" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${c_ibflag} == 'I')" ).append("\n"); 
		query.append("INSERT" ).append("\n"); 
		query.append("INTO BKG_CSTMS_EUR_CUST( VSL_CD, SKD_VOY_NO, SKD_DIR_CD, CUST_CNT_CD, CUST_SEQ, BL_NO, CSTMS_PORT_CD, BKG_CUST_TP_CD, CUST_NM, CUST_ADDR, CUST_CTY_NM, EUR_CSTMS_ST_NM, EORI_NO,  CRE_USR_ID, CRE_DT, UPD_USR_ID, UPD_DT, CSTMS_DECL_CNT_CD, CUST_ZIP_ID)" ).append("\n"); 
		query.append("VALUES( SUBSTR(@[vvd], 1, 4)," ).append("\n"); 
		query.append("      SUBSTR(@[vvd], 5, 4)," ).append("\n"); 
		query.append("      SUBSTR(@[vvd], 9, 1)," ).append("\n"); 
		query.append("	  @[c_cust_cnt_cd]," ).append("\n"); 
		query.append("	  @[c_cust_seq]," ).append("\n"); 
		query.append("      @[bl_no]," ).append("\n"); 
		query.append("      @[cstms_port_cd]," ).append("\n"); 
		query.append("      'C'," ).append("\n"); 
		query.append("      @[c_cust_nm]," ).append("\n"); 
		query.append("      @[c_cust_addr]," ).append("\n"); 
		query.append("      BKG_SPCLCHAR_CONV_FNC(@[c_cust_cty_nm],'X')," ).append("\n"); 
		query.append("      BKG_SPCLCHAR_CONV_FNC(@[c_eur_cstms_st_nm],'X')," ).append("\n"); 
		query.append("      @[c_eori_no]," ).append("\n"); 
		query.append("      @[cre_usr_id]," ).append("\n"); 
		query.append("      sysdate," ).append("\n"); 
		query.append("      @[upd_usr_id]," ).append("\n"); 
		query.append("      sysdate," ).append("\n"); 
		query.append("      @[c_cstms_decl_cnt_cd]," ).append("\n"); 
		query.append("      BKG_SPCLCHAR_CONV_FNC(@[c_cust_zip_id]),'X')" ).append("\n"); 
		query.append("      );" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${n_ibflag} == 'I')" ).append("\n"); 
		query.append("INSERT" ).append("\n"); 
		query.append("INTO BKG_CSTMS_EUR_CUST( VSL_CD, SKD_VOY_NO, SKD_DIR_CD, CUST_CNT_CD, CUST_SEQ, BL_NO, CSTMS_PORT_CD, BKG_CUST_TP_CD, CUST_NM, CUST_ADDR, CUST_CTY_NM, EUR_CSTMS_ST_NM, EORI_NO, CRE_USR_ID, CRE_DT, UPD_USR_ID, UPD_DT, CSTMS_DECL_CNT_CD, CUST_ZIP_ID)" ).append("\n"); 
		query.append("VALUES( SUBSTR(@[vvd], 1, 4)," ).append("\n"); 
		query.append("      SUBSTR(@[vvd], 5, 4)," ).append("\n"); 
		query.append("      SUBSTR(@[vvd], 9, 1)," ).append("\n"); 
		query.append("	  @[n_cust_cnt_cd]," ).append("\n"); 
		query.append("	  @[n_cust_seq]," ).append("\n"); 
		query.append("      @[bl_no]," ).append("\n"); 
		query.append("      @[cstms_port_cd]," ).append("\n"); 
		query.append("      'N'," ).append("\n"); 
		query.append("      @[n_cust_nm]," ).append("\n"); 
		query.append("      @[n_cust_addr]," ).append("\n"); 
		query.append("      BKG_SPCLCHAR_CONV_FNC(@[n_cust_cty_nm],'X')," ).append("\n"); 
		query.append("      BKG_SPCLCHAR_CONV_FNC(@[n_eur_cstms_st_nm],'X')," ).append("\n"); 
		query.append("      @[n_eori_no]," ).append("\n"); 
		query.append("      @[cre_usr_id]," ).append("\n"); 
		query.append("      sysdate," ).append("\n"); 
		query.append("      @[upd_usr_id]," ).append("\n"); 
		query.append("      sysdate," ).append("\n"); 
		query.append("      @[n_cstms_decl_cnt_cd]," ).append("\n"); 
		query.append("      BKG_SPCLCHAR_CONV_FNC(@[n_cust_zip_id],'X')" ).append("\n"); 
		query.append("      );" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(" EXCEPTION WHEN VALUE_ERROR THEN ROLLBACK;" ).append("\n"); 
		query.append(" WHEN OTHERS THEN ROLLBACK;" ).append("\n"); 
		query.append(" COMMIT;" ).append("\n"); 
		query.append(" END;" ).append("\n"); 

	}
}