/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : InlandRatesDBDAOPriTrfInlndProgVOCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.11.02
*@LastModifier : 최성민
*@LastVersion : 1.0
* 2010.11.02 최성민
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.tariff.inlandrates.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author CHOI SUNGMIN
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class InlandRatesDBDAOPriTrfInlndProgVOCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Inland Progress 추가
	  * </pre>
	  */
	public InlandRatesDBDAOPriTrfInlndProgVOCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("prog_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trf_inlnd_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trf_pfx_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("prog_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("trf_inlnd_sts_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trf_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("amdt_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.pri.tariff.inlandrates.integration ").append("\n"); 
		query.append("FileName : InlandRatesDBDAOPriTrfInlndProgVOCSQL").append("\n"); 
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
		query.append("INSERT INTO PRI_TRF_INLND_PROG" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("	   TRF_PFX_CD" ).append("\n"); 
		query.append("	 , TRF_NO" ).append("\n"); 
		query.append("	 , TRF_INLND_SEQ" ).append("\n"); 
		query.append("	 , AMDT_SEQ" ).append("\n"); 
		query.append("	 , TRF_INLND_PROG_SEQ" ).append("\n"); 
		query.append("	 , TRF_INLND_STS_CD" ).append("\n"); 
		query.append("	 , PROG_USR_ID" ).append("\n"); 
		query.append("	 , PROG_OFC_CD" ).append("\n"); 
		query.append("	 , PROG_DT" ).append("\n"); 
		query.append("	 , CRE_USR_ID" ).append("\n"); 
		query.append("	 , CRE_DT" ).append("\n"); 
		query.append("	 , UPD_USR_ID" ).append("\n"); 
		query.append("	 , UPD_DT" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SELECT @[trf_pfx_cd]" ).append("\n"); 
		query.append("	 , @[trf_no]" ).append("\n"); 
		query.append("	 , @[trf_inlnd_seq]" ).append("\n"); 
		query.append("	 , @[amdt_seq]" ).append("\n"); 
		query.append("	 , NVL(MAX(TRF_INLND_PROG_SEQ)+1, 1)" ).append("\n"); 
		query.append("	 , @[trf_inlnd_sts_cd]" ).append("\n"); 
		query.append("	 , @[prog_usr_id]" ).append("\n"); 
		query.append("	 , @[prog_ofc_cd]" ).append("\n"); 
		query.append("	 , SYSDATE" ).append("\n"); 
		query.append("	 , @[cre_usr_id]" ).append("\n"); 
		query.append("	 , SYSDATE" ).append("\n"); 
		query.append("	 , @[upd_usr_id]" ).append("\n"); 
		query.append("	 , SYSDATE" ).append("\n"); 
		query.append("  FROM PRI_TRF_INLND_PROG" ).append("\n"); 
		query.append(" WHERE TRF_PFX_CD		= @[trf_pfx_cd]" ).append("\n"); 
		query.append("   AND TRF_NO			= @[trf_no]" ).append("\n"); 
		query.append("   AND TRF_INLND_SEQ	= @[trf_inlnd_seq]" ).append("\n"); 
		query.append("   AND AMDT_SEQ			= @[amdt_seq]" ).append("\n"); 

	}
}