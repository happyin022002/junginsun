/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : Eur24ManifestDownloadDBDAORemoveBlCustDSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.12.02
*@LastModifier : 
*@LastVersion : 1.0
* 2010.12.02 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.eur24.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class Eur24ManifestDownloadDBDAORemoveBlCustDSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * BKG_CSTMS_EUR_CUST 정보 삭제
	  * </pre>
	  */
	public Eur24ManifestDownloadDBDAORemoveBlCustDSQL(){
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
		params.put("bl_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_seq",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cust_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.eur24.integration ").append("\n"); 
		query.append("FileName : Eur24ManifestDownloadDBDAORemoveBlCustDSQL").append("\n"); 
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
		query.append("#if (${s_ibflag} == 'D')" ).append("\n"); 
		query.append("DELETE BKG_CSTMS_EUR_CUST" ).append("\n"); 
		query.append("WHERE VSL_CD||SKD_VOY_NO||SKD_DIR_CD = @[vvd]" ).append("\n"); 
		query.append("  AND BL_NO = @[bl_no]" ).append("\n"); 
		query.append("  AND CSTMS_PORT_CD = @[cstms_port_cd]" ).append("\n"); 
		query.append("  AND CUST_CNT_CD = @[cust_cnt_cd]" ).append("\n"); 
		query.append("  AND CUST_SEQ = @[cust_seq]" ).append("\n"); 
		query.append("  AND BKG_CUST_TP_CD = 'S';" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${f_ibflag} == 'D')" ).append("\n"); 
		query.append("DELETE BKG_CSTMS_EUR_CUST" ).append("\n"); 
		query.append("WHERE VSL_CD||SKD_VOY_NO||SKD_DIR_CD = @[vvd]" ).append("\n"); 
		query.append("  AND BL_NO = @[bl_no]" ).append("\n"); 
		query.append("  AND CSTMS_PORT_CD = @[cstms_port_cd]" ).append("\n"); 
		query.append("  AND CUST_CNT_CD = @[cust_cnt_cd]" ).append("\n"); 
		query.append("  AND CUST_SEQ = @[cust_seq]" ).append("\n"); 
		query.append("  AND BKG_CUST_TP_CD = 'F';" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${c_ibflag} == 'D')" ).append("\n"); 
		query.append("DELETE BKG_CSTMS_EUR_CUST" ).append("\n"); 
		query.append("WHERE VSL_CD||SKD_VOY_NO||SKD_DIR_CD = @[vvd]" ).append("\n"); 
		query.append("  AND BL_NO = @[bl_no]" ).append("\n"); 
		query.append("  AND CSTMS_PORT_CD = @[cstms_port_cd]" ).append("\n"); 
		query.append("  AND CUST_CNT_CD = @[cust_cnt_cd]" ).append("\n"); 
		query.append("  AND CUST_SEQ = @[cust_seq]" ).append("\n"); 
		query.append("  AND BKG_CUST_TP_CD = 'C';" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${n_ibflag} == 'D')" ).append("\n"); 
		query.append("DELETE BKG_CSTMS_EUR_CUST" ).append("\n"); 
		query.append("WHERE VSL_CD||SKD_VOY_NO||SKD_DIR_CD = @[vvd]" ).append("\n"); 
		query.append("  AND BL_NO = @[bl_no]" ).append("\n"); 
		query.append("  AND CSTMS_PORT_CD = @[cstms_port_cd]" ).append("\n"); 
		query.append("  AND CUST_CNT_CD = @[cust_cnt_cd]" ).append("\n"); 
		query.append("  AND CUST_SEQ = @[cust_seq]" ).append("\n"); 
		query.append("  AND BKG_CUST_TP_CD = 'N';" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(" EXCEPTION WHEN VALUE_ERROR THEN ROLLBACK;" ).append("\n"); 
		query.append(" WHEN OTHERS THEN ROLLBACK;" ).append("\n"); 
		query.append(" COMMIT;" ).append("\n"); 
		query.append(" END;" ).append("\n"); 

	}
}