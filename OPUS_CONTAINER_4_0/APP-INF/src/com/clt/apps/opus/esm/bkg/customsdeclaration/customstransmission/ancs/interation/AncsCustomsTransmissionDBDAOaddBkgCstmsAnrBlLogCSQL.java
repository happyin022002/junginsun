/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : AncsCustomsTransmissionDBDAOaddBkgCstmsAnrBlLogCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.09.12
*@LastModifier : 이종길
*@LastVersion : 1.0
* 2016.09.12 이종길
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.ancs.interation;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Jong-Kil LEE
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AncsCustomsTransmissionDBDAOaddBkgCstmsAnrBlLogCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * i
	  * </pre>
	  */
	public AncsCustomsTransmissionDBDAOaddBkgCstmsAnrBlLogCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("bl_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("ref_seq",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("upd_usr_id",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.ancs.interation").append("\n"); 
		query.append("FileName : AncsCustomsTransmissionDBDAOaddBkgCstmsAnrBlLogCSQL").append("\n"); 
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
		query.append("INSERT INTO BKG_CSTMS_ANR_BL_LOG" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("MSG_TP_CD" ).append("\n"); 
		query.append(",ANR_DECL_NO" ).append("\n"); 
		query.append(",REF_SEQ" ).append("\n"); 
		query.append(",BL_NO" ).append("\n"); 
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
		query.append(",VVD_SEQ" ).append("\n"); 
		query.append(") VALUES (" ).append("\n"); 
		query.append(" 'C'" ).append("\n"); 
		query.append(",@[anr_decl_no] --ANR_DECL_NO" ).append("\n"); 
		query.append(",@[ref_seq] --REF_SEQ" ).append("\n"); 
		query.append(",@[bl_no]--BL_NO" ).append("\n"); 
		query.append(",@[vsl_cd] --VSL_CD" ).append("\n"); 
		query.append(",@[skd_voy_no] --SKD_VOY_NO" ).append("\n"); 
		query.append(",@[skd_dir_cd] --SKD_DIR_CD" ).append("\n"); 
		query.append(",@[bkg_no] -- BKG_NO" ).append("\n"); 
		query.append("--,'A'--EDI_RCV_STS_CD  -- BKG_CSTMS_ANR_BL.ANR_MSG_STS_CD" ).append("\n"); 
		query.append(",@[cre_usr_id] --CRE_USR_ID" ).append("\n"); 
		query.append(",SYSDATE" ).append("\n"); 
		query.append(",@[upd_usr_id] --UPD_USR_ID" ).append("\n"); 
		query.append(",SYSDATE" ).append("\n"); 
		query.append(",(SELECT VVD_SEQ" ).append("\n"); 
		query.append("  FROM BKG_CSTMS_ANR_BL" ).append("\n"); 
		query.append("  WHERE BL_NO = @[bl_no]" ).append("\n"); 
		query.append("  AND VSL_CD = @[vsl_cd]" ).append("\n"); 
		query.append("  AND SKD_VOY_NO = @[skd_voy_no]" ).append("\n"); 
		query.append("  AND SKD_DIR_CD = @[skd_dir_cd])" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}