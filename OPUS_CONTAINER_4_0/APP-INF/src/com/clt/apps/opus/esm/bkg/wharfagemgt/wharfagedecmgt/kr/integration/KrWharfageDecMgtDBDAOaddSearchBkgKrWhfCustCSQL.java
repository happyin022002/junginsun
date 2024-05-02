/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : KrWharfageDecMgtDBDAOaddSearchBkgKrWhfCustCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.03.10
*@LastModifier : 
*@LastVersion : 1.0
* 2011.03.10 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.wharfagemgt.wharfagedecmgt.kr.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class KrWharfageDecMgtDBDAOaddSearchBkgKrWhfCustCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * i
	  * </pre>
	  */
	public KrWharfageDecMgtDBDAOaddSearchBkgKrWhfCustCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("skd_dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fax_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("whf_bnd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.wharfagemgt.wharfagedecmgt.kr.integration").append("\n"); 
		query.append("FileName : KrWharfageDecMgtDBDAOaddSearchBkgKrWhfCustCSQL").append("\n"); 
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
		query.append("INSERT INTO BKG_KR_WHF_CUST X" ).append("\n"); 
		query.append("(X.VSL_CD," ).append("\n"); 
		query.append("X.SKD_VOY_NO," ).append("\n"); 
		query.append("X.SKD_DIR_CD," ).append("\n"); 
		query.append("X.BL_NO," ).append("\n"); 
		query.append("X.BKG_CUST_TP_CD," ).append("\n"); 
		query.append("X.CNT_CD," ).append("\n"); 
		query.append("X.CUST_SEQ," ).append("\n"); 
		query.append("X.CUST_NM," ).append("\n"); 
		query.append("X.CUST_ADDR," ).append("\n"); 
		query.append("X.PHN_NO," ).append("\n"); 
		query.append("X.FAX_NO," ).append("\n"); 
		query.append("X.CRE_USR_ID," ).append("\n"); 
		query.append("X.CRE_DT," ).append("\n"); 
		query.append("X.UPD_USR_ID," ).append("\n"); 
		query.append("X.UPD_DT)" ).append("\n"); 
		query.append("SELECT @[vsl_cd], @[skd_voy_no], @[skd_dir_cd]," ).append("\n"); 
		query.append("       A.BL_NO," ).append("\n"); 
		query.append("       B.BKG_CUST_TP_CD," ).append("\n"); 
		query.append("       B.CUST_CNT_CD," ).append("\n"); 
		query.append("       B.CUST_SEQ, " ).append("\n"); 
		query.append("       B.CUST_NM, " ).append("\n"); 
		query.append("       B.CUST_ADDR, " ).append("\n"); 
		query.append("       NULL AS PHN_NO," ).append("\n"); 
		query.append("       B.CUST_FAX_NO, " ).append("\n"); 
		query.append("       @[cre_usr_id]," ).append("\n"); 
		query.append("       SYSDATE," ).append("\n"); 
		query.append("       @[upd_usr_id]," ).append("\n"); 
		query.append("       SYSDATE" ).append("\n"); 
		query.append("  FROM BKG_BOOKING A, BKG_CUSTOMER B" ).append("\n"); 
		query.append(" WHERE A.BKG_NO = @[fax_no]" ).append("\n"); 
		query.append("   AND B.BKG_NO = A.BKG_NO" ).append("\n"); 
		query.append("   AND B.BKG_CUST_TP_CD IN (DECODE(@[whf_bnd_cd], 'II', 'S', B.BKG_CUST_TP_CD)," ).append("\n"); 
		query.append("                            DECODE(@[whf_bnd_cd], 'II', 'C', B.BKG_CUST_TP_CD)," ).append("\n"); 
		query.append("                            DECODE(@[whf_bnd_cd], 'II', 'N', B.BKG_CUST_TP_CD))" ).append("\n"); 

	}
}