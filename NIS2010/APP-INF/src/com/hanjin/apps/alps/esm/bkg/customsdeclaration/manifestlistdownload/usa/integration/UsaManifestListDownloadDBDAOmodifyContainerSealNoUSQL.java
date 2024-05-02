/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : UsaManifestListDownloadDBDAOmodifyContainerSealNoUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.25
*@LastModifier : 
*@LastVersion : 1.0
* 2009.11.25 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.usa.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class UsaManifestListDownloadDBDAOmodifyContainerSealNoUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * modifyContainerSealNo
	  * </pre>
	  */
	public UsaManifestListDownloadDBDAOmodifyContainerSealNoUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("seal_no_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cstms_div_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.usa.integration").append("\n"); 
		query.append("FileName : UsaManifestListDownloadDBDAOmodifyContainerSealNoUSQL").append("\n"); 
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
		query.append("MERGE INTO BKG_CSTMS_SEAL_NO T1" ).append("\n"); 
		query.append("USING (" ).append("\n"); 
		query.append("SELECT  @[cnt_cd] AS CNT_CD" ).append("\n"); 
		query.append(",NVL(@[cstms_div_id],'CTM') AS CSTMS_DIV_ID" ).append("\n"); 
		query.append(",@[bl_no] AS BL_NO" ).append("\n"); 
		query.append(",@[cntr_no] AS CNTR_NO" ).append("\n"); 
		query.append(",@[seal_no_seq] AS SEAL_NO_SEQ" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 
		query.append(") T2" ).append("\n"); 
		query.append("ON ( T1.CNT_CD  = T2.CNT_CD AND" ).append("\n"); 
		query.append("T1.CSTMS_DIV_ID = T2.CSTMS_DIV_ID AND" ).append("\n"); 
		query.append("T1.BL_NO   = T2.BL_NO AND" ).append("\n"); 
		query.append("T1.CNTR_NO = T2.CNTR_NO AND" ).append("\n"); 
		query.append("T1.SEAL_NO_SEQ = T2.SEAL_NO_SEQ" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("WHEN MATCHED THEN" ).append("\n"); 
		query.append("UPDATE" ).append("\n"); 
		query.append("SET      SEAL_NO = @[seal_no]" ).append("\n"); 
		query.append(",        UPD_USR_ID = @[usr_id]" ).append("\n"); 
		query.append(",        UPD_DT = SYSDATE" ).append("\n"); 
		query.append("WHEN NOT MATCHED THEN" ).append("\n"); 
		query.append("INSERT ( CNT_CD" ).append("\n"); 
		query.append(",CSTMS_DIV_ID" ).append("\n"); 
		query.append(",BL_NO" ).append("\n"); 
		query.append(",CNTR_NO" ).append("\n"); 
		query.append(",SEAL_NO_SEQ" ).append("\n"); 
		query.append(",SEAL_NO" ).append("\n"); 
		query.append(",CRE_USR_ID" ).append("\n"); 
		query.append(",CRE_DT" ).append("\n"); 
		query.append(",UPD_USR_ID" ).append("\n"); 
		query.append(",UPD_DT )" ).append("\n"); 
		query.append("VALUES ( @[cnt_cd]" ).append("\n"); 
		query.append(",NVL(@[cstms_div_id],'CTM')" ).append("\n"); 
		query.append(",@[bl_no]" ).append("\n"); 
		query.append(",@[cntr_no]" ).append("\n"); 
		query.append(",NVL((SELECT /*+ index_desc(A XPKBKG_CSTMS_SEAL_NO SL) */" ).append("\n"); 
		query.append("SEAL_NO_SEQ" ).append("\n"); 
		query.append("FROM   BKG_CSTMS_SEAL_NO A" ).append("\n"); 
		query.append("WHERE  1=1" ).append("\n"); 
		query.append("AND	 CNT_CD = @[cnt_cd]" ).append("\n"); 
		query.append("AND    CSTMS_DIV_ID = NVL(@[cstms_div_id],'CTM')" ).append("\n"); 
		query.append("AND    BL_NO = @[bl_no]" ).append("\n"); 
		query.append("AND    CNTR_NO = @[cntr_no]" ).append("\n"); 
		query.append("AND    ROWNUM = 1" ).append("\n"); 
		query.append("),0)+1" ).append("\n"); 
		query.append(",@[seal_no]" ).append("\n"); 
		query.append(",@[usr_id]" ).append("\n"); 
		query.append(",SYSDATE" ).append("\n"); 
		query.append(",@[usr_id]" ).append("\n"); 
		query.append(",SYSDATE )" ).append("\n"); 

	}
}