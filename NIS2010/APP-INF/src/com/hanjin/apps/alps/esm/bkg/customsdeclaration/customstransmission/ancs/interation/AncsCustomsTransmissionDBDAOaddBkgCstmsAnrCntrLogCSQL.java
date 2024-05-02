/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : AncsCustomsTransmissionDBDAOaddBkgCstmsAnrCntrLogCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.10
*@LastModifier : 김승민
*@LastVersion : 1.0
* 2010.03.10 김승민
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.ancs.interation;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author KIM SEUNG MIN
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AncsCustomsTransmissionDBDAOaddBkgCstmsAnrCntrLogCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * i
	  * </pre>
	  */
	public AncsCustomsTransmissionDBDAOaddBkgCstmsAnrCntrLogCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ref_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("anr_decl_no",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("Path : com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.ancs.interation").append("\n"); 
		query.append("FileName : AncsCustomsTransmissionDBDAOaddBkgCstmsAnrCntrLogCSQL").append("\n"); 
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
		query.append("INSERT INTO BKG_CSTMS_ANR_CNTR_LOG" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append(" MSG_TP_CD" ).append("\n"); 
		query.append(",ANR_DECL_NO" ).append("\n"); 
		query.append(",REF_SEQ" ).append("\n"); 
		query.append(",CNTR_NO" ).append("\n"); 
		query.append(",VSL_CD" ).append("\n"); 
		query.append(",SKD_VOY_NO" ).append("\n"); 
		query.append(",SKD_DIR_CD" ).append("\n"); 
		query.append(",BKG_NO" ).append("\n"); 
		query.append("--,EDI_RCV_STS_CD" ).append("\n"); 
		query.append("--,EDI_MSG_ERR_ID" ).append("\n"); 
		query.append("--,ERR_DESC" ).append("\n"); 
		query.append("--,MSG_LOC_CD" ).append("\n"); 
		query.append("--,ERR_CTNT" ).append("\n"); 
		query.append(",CRE_USR_ID" ).append("\n"); 
		query.append(",CRE_DT" ).append("\n"); 
		query.append(",UPD_USR_ID" ).append("\n"); 
		query.append(",UPD_DT" ).append("\n"); 
		query.append(") VALUES (" ).append("\n"); 
		query.append("'C'" ).append("\n"); 
		query.append(",@[anr_decl_no]--ANR_DECL_NO" ).append("\n"); 
		query.append(",@[ref_seq] --REF_SEQ" ).append("\n"); 
		query.append(",@[cntr_no] --CNTR_NO" ).append("\n"); 
		query.append(",@[vsl_cd] --VSL_CD" ).append("\n"); 
		query.append(",@[skd_voy_no] --SKD_VOY_NO" ).append("\n"); 
		query.append(",@[skd_dir_cd] --SKD_DIR_CD" ).append("\n"); 
		query.append(",@[bkg_no]--BKG_NO" ).append("\n"); 
		query.append("--,'A' --EDI_RCV_STS_CD" ).append("\n"); 
		query.append("--,NULL --EDI_MSG_ERR_ID" ).append("\n"); 
		query.append("--,NULL --ERR_DESC" ).append("\n"); 
		query.append("--,NULL --MSG_LOC_CD" ).append("\n"); 
		query.append("--,NULL --ERR_CTNT" ).append("\n"); 
		query.append(",@[cre_usr_id] --CRE_USR_ID" ).append("\n"); 
		query.append(",SYSDATE" ).append("\n"); 
		query.append(",@[upd_usr_id] --UPD_USR_ID" ).append("\n"); 
		query.append(",SYSDATE" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}