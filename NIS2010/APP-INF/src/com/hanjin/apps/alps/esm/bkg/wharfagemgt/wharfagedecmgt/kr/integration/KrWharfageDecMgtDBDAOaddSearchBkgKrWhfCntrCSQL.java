/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : KrWharfageDecMgtDBDAOaddSearchBkgKrWhfCntrCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.27
*@LastModifier : 정재엽
*@LastVersion : 1.0
* 2009.08.27 정재엽
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.wharfagemgt.wharfagedecmgt.kr.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Jeong Jae Yoeb
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class KrWharfageDecMgtDBDAOaddSearchBkgKrWhfCntrCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * i
	  * </pre>
	  */
	public KrWharfageDecMgtDBDAOaddSearchBkgKrWhfCntrCSQL(){
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
		params.put("cntr_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.wharfagemgt.wharfagedecmgt.kr.integration").append("\n"); 
		query.append("FileName : KrWharfageDecMgtDBDAOaddSearchBkgKrWhfCntrCSQL").append("\n"); 
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
		query.append("INSERT INTO BKG_KR_WHF_CNTR X" ).append("\n"); 
		query.append("(X.VSL_CD," ).append("\n"); 
		query.append("X.SKD_VOY_NO," ).append("\n"); 
		query.append("X.SKD_DIR_CD," ).append("\n"); 
		query.append("X.BL_NO," ).append("\n"); 
		query.append("X.CNTR_NO," ).append("\n"); 
		query.append("X.CNTR_TPSZ_CD," ).append("\n"); 
		query.append("X.PCK_TP_CD," ).append("\n"); 
		query.append("X.WGT_QTY," ).append("\n"); 
		query.append("X.WGT_UT_CD," ).append("\n"); 
		query.append("X.CNTR_FULL_FLG," ).append("\n"); 
		query.append("X.CRE_USR_ID," ).append("\n"); 
		query.append("X.CRE_DT," ).append("\n"); 
		query.append("X.UPD_USR_ID," ).append("\n"); 
		query.append("X.UPD_DT)" ).append("\n"); 
		query.append("SELECT @[vsl_cd], @[skd_voy_no], @[skd_dir_cd]," ).append("\n"); 
		query.append("A.BL_NO," ).append("\n"); 
		query.append("B.CNTR_NO," ).append("\n"); 
		query.append("B.CNTR_TPSZ_CD," ).append("\n"); 
		query.append("B.PCK_TP_CD," ).append("\n"); 
		query.append("B.CNTR_WGT," ).append("\n"); 
		query.append("B.WGT_UT_CD," ).append("\n"); 
		query.append("CASE WHEN A.BKG_CGO_TP_CD IN ('P', 'R') THEN 'N'" ).append("\n"); 
		query.append("ELSE 'Y'" ).append("\n"); 
		query.append("END," ).append("\n"); 
		query.append("@[cre_usr_id]," ).append("\n"); 
		query.append("SYSDATE," ).append("\n"); 
		query.append("@[upd_usr_id]," ).append("\n"); 
		query.append("SYSDATE" ).append("\n"); 
		query.append("FROM BKG_BOOKING A, NISADM.BKG_CONTAINER B" ).append("\n"); 
		query.append("WHERE A.BKG_NO = @[cntr_no]" ).append("\n"); 
		query.append("AND B.BKG_NO = A.BKG_NO" ).append("\n"); 

	}
}