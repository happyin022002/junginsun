/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : EqInterchangeDBDAOMasOffhBkgListUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.04.14
*@LastModifier : 
*@LastVersion : 1.0
* 2016.04.14 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.lse.containerleasemgt.eqinterchangemgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class EqInterchangeDBDAOMasOffhBkgListUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 2016-04-11
	  * </pre>
	  */
	public EqInterchangeDBDAOMasOffhBkgListUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("cntr_tpsz_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.lse.containerleasemgt.eqinterchangemgt.integration").append("\n"); 
		query.append("FileName : EqInterchangeDBDAOMasOffhBkgListUSQL").append("\n"); 
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
		query.append("MERGE INTO MAS_OFFH_BKG_LIST A" ).append("\n"); 
		query.append("USING DUAL ON (A.CNTR_NO      = @[cntr_no]" ).append("\n"); 
		query.append("               AND A.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("WHEN MATCHED" ).append("\n"); 
		query.append("THEN UPDATE SET " ).append("\n"); 
		query.append("             A.UPD_DT   = SYSDATE" ).append("\n"); 
		query.append("            ,A.UPD_USR_ID = @[upd_usr_id]              " ).append("\n"); 
		query.append("     WHERE  1=1" ).append("\n"); 
		query.append("       AND A.CNTR_NO = @[cntr_no]" ).append("\n"); 
		query.append("       AND A.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("WHEN NOT MATCHED" ).append("\n"); 
		query.append("THEN INSERT (A.CNTR_NO" ).append("\n"); 
		query.append("            ,A.BKG_NO" ).append("\n"); 
		query.append("            ,A.TPSZ_CD" ).append("\n"); 
		query.append("            ,A.UPD_DT" ).append("\n"); 
		query.append("            ,A.UPD_USR_ID" ).append("\n"); 
		query.append("            ,A.CRE_DT" ).append("\n"); 
		query.append("            ,A.CRE_USR_ID" ).append("\n"); 
		query.append("            )" ).append("\n"); 
		query.append("     VALUES (@[cntr_no]           " ).append("\n"); 
		query.append("            ,@[bkg_no]" ).append("\n"); 
		query.append("            ,@[cntr_tpsz_cd]                " ).append("\n"); 
		query.append("            ,SYSDATE        " ).append("\n"); 
		query.append("            ,@[upd_usr_id]                    " ).append("\n"); 
		query.append("            ,SYSDATE              " ).append("\n"); 
		query.append("            ,@[upd_usr_id]                 " ).append("\n"); 
		query.append("     )" ).append("\n"); 

	}
}