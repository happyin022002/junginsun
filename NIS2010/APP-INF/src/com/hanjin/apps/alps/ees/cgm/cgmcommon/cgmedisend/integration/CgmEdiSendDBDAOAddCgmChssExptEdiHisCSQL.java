/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : CgmEdiSendDBDAOAddCgmChssExptEdiHisCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.08.09
*@LastModifier : 
*@LastVersion : 1.0
* 2016.08.09 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.cgm.cgmcommon.cgmedisend.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CgmEdiSendDBDAOAddCgmChssExptEdiHisCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Chss EID 발송 정보 저장
	  * </pre>
	  */
	public CgmEdiSendDBDAOAddCgmChssExptEdiHisCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fmInd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("chz_except",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("chz_except_days",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ie_ind",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("skd_voy",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkgnbr",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("skd_dir",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.cgm.cgmcommon.cgmedisend.integration").append("\n"); 
		query.append("FileName : CgmEdiSendDBDAOAddCgmChssExptEdiHisCSQL").append("\n"); 
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
		query.append("INSERT INTO  CGM_CHSS_EXPT_EDI_HIS" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("    BKG_NO" ).append("\n"); 
		query.append("   ,CNTR_NO" ).append("\n"); 
		query.append("   ,EDI_HIS_SEQ" ).append("\n"); 
		query.append("   ,EDI_ISS_DT" ).append("\n"); 
		query.append("   ,EDI_ISS_USR_ID" ).append("\n"); 
		query.append("   ,CHSS_EXPT_FLG" ).append("\n"); 
		query.append("   ,CHSS_FT_DYS" ).append("\n"); 
		query.append("   ,FULL_MTY_CD" ).append("\n"); 
		query.append("   ,IO_BND_CD" ).append("\n"); 
		query.append("   ,VSL_CD" ).append("\n"); 
		query.append("   ,SKD_VOY_NO" ).append("\n"); 
		query.append("   ,SKD_DIR_CD" ).append("\n"); 
		query.append("   ,CRE_USR_ID" ).append("\n"); 
		query.append("   ,CRE_DT" ).append("\n"); 
		query.append("   ,UPD_USR_ID" ).append("\n"); 
		query.append("   ,UPD_DT" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("VALUES " ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("    @[bkgnbr]" ).append("\n"); 
		query.append("   ,@[cntr_no]" ).append("\n"); 
		query.append("   ,(SELECT NVL(MAX(EDI_HIS_SEQ),0)+1 FROM CGM_CHSS_EXPT_EDI_HIS WHERE BKG_NO = @[bkgnbr] AND CNTR_NO=@[cntr_no])" ).append("\n"); 
		query.append("   ,SYSDATE " ).append("\n"); 
		query.append("   ,'SYSTEM'" ).append("\n"); 
		query.append("   ,@[chz_except]" ).append("\n"); 
		query.append("   ,@[chz_except_days]" ).append("\n"); 
		query.append("   ,@[fmInd]" ).append("\n"); 
		query.append("   ,@[ie_ind]" ).append("\n"); 
		query.append("   ,@[vsl_cd]" ).append("\n"); 
		query.append("   ,@[skd_voy]" ).append("\n"); 
		query.append("   ,@[skd_dir]" ).append("\n"); 
		query.append("   ,'SYSTEM'" ).append("\n"); 
		query.append("   ,SYSDATE" ).append("\n"); 
		query.append("   ,'SYSTEM'" ).append("\n"); 
		query.append("   ,SYSDATE" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}