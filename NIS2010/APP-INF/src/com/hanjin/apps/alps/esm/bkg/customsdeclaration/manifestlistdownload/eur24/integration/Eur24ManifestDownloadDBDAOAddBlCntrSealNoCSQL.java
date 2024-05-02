/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : Eur24ManifestDownloadDBDAOAddBlCntrSealNoCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.11.29
*@LastModifier : 
*@LastVersion : 1.0
* 2010.11.29 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.eur24.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class Eur24ManifestDownloadDBDAOAddBlCntrSealNoCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * BKG_CSTMS_EUR_SEAL_NO table에 데이터 저장
	  * </pre>
	  */
	public Eur24ManifestDownloadDBDAOAddBlCntrSealNoCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("seal_pty_nm",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("seal_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("seal_knd_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("seal_pty_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.eur24.integration").append("\n"); 
		query.append("FileName : Eur24ManifestDownloadDBDAOAddBlCntrSealNoCSQL").append("\n"); 
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
		query.append("INSERT INTO " ).append("\n"); 
		query.append("BKG_CSTMS_EUR_SEAL_NO " ).append("\n"); 
		query.append("(   VSL_CD,     SKD_VOY_NO,     SKD_DIR_CD, " ).append("\n"); 
		query.append("	BL_NO,      CSTMS_PORT_CD,  CNTR_NO,    " ).append("\n"); 
		query.append("	SEAL_NO,    SEAL_PTY_TP_CD, SEAL_PTY_NM,	" ).append("\n"); 
		query.append("	SEAL_KND_CD,CRE_USR_ID,     CRE_DT,     " ).append("\n"); 
		query.append("	UPD_USR_ID,     UPD_DT,    SEAL_NO_SEQ" ).append("\n"); 
		query.append(")VALUES(" ).append("\n"); 
		query.append("    SUBSTR(@[vvd], 1, 4),   SUBSTR(@[vvd], 5, 4),   SUBSTR(@[vvd], 9, 1)," ).append("\n"); 
		query.append("      @[bl_no],             @[cstms_port_cd],       @[cntr_no]," ).append("\n"); 
		query.append("      @[seal_no],       	@[seal_pty_tp_cd],      @[seal_pty_nm]," ).append("\n"); 
		query.append("      @[seal_knd_cd],       @[cre_usr_id],			SYSDATE," ).append("\n"); 
		query.append("      @[upd_usr_id],        SYSDATE, " ).append("\n"); 
		query.append("	(SELECT NVL(MAX(TO_NUMBER(SEAL_NO_SEQ)), 0) + 1" ).append("\n"); 
		query.append("        FROM BKG_CSTMS_EUR_SEAL_NO" ).append("\n"); 
		query.append("        WHERE VSL_CD||SKd_VOY_NO||SKD_DIR_CD = @[vvd]" ).append("\n"); 
		query.append("          AND BL_NO = @[bl_no]" ).append("\n"); 
		query.append("          AND CSTMS_PORT_CD = @[cstms_port_cd]" ).append("\n"); 
		query.append("          AND CNTR_NO = @[cntr_no]))" ).append("\n"); 

	}
}