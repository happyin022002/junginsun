/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : BLDocumentationCMDBDAOcopyBkgCntrSealByBKGCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.10.27
*@LastModifier : 
*@LastVersion : 1.0
* 2015.10.27 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BLDocumentationCMDBDAOcopyBkgCntrSealByBKGCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * insert
	  * </pre>
	  */
	public BLDocumentationCMDBDAOcopyBkgCntrSealByBKGCSQL(){
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
		params.put("cntr_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("from_bkg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("to_bkg",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.integration").append("\n"); 
		query.append("FileName : BLDocumentationCMDBDAOcopyBkgCntrSealByBKGCSQL").append("\n"); 
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
		query.append("insert into bkg_cntr_seal_no(BKG_NO " ).append("\n"); 
		query.append(",CNTR_NO " ).append("\n"); 
		query.append(",CNTR_SEAL_SEQ " ).append("\n"); 
		query.append(",CNTR_SEAL_NO " ).append("\n"); 
		query.append(",SEAL_PTY_NM " ).append("\n"); 
		query.append(",SEAL_KND_CD" ).append("\n"); 
		query.append(",PRN_FLG " ).append("\n"); 
		query.append(",CRE_USR_ID " ).append("\n"); 
		query.append(",CRE_DT " ).append("\n"); 
		query.append(",UPD_USR_ID " ).append("\n"); 
		query.append(",UPD_DT" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("select @[to_bkg] BKG_NO " ).append("\n"); 
		query.append("		,CNTR_NO " ).append("\n"); 
		query.append("		,(select /*+index_desc ( bkg_cntr_seal_no XPKBKG_CNTR_SEAL_NO)*/ " ).append("\n"); 
		query.append("					nvl(sum(CNTR_SEAL_SEQ ),0)+ seal.cntr_seal_seq" ).append("\n"); 
		query.append("					from bkg_cntr_seal_no" ).append("\n"); 
		query.append("					where CNTR_SEAL_SEQ   >= 0 " ).append("\n"); 
		query.append("					and rownum <= 1 " ).append("\n"); 
		query.append("					and bkg_no = @[to_bkg] " ).append("\n"); 
		query.append("				    and cntr_no = @[cntr_no]) CNTR_SEAL_SEQ " ).append("\n"); 
		query.append("		,CNTR_SEAL_NO" ).append("\n"); 
		query.append("		,SEAL_PTY_NM " ).append("\n"); 
		query.append("		,SEAL_KND_CD" ).append("\n"); 
		query.append("		,PRN_FLG " ).append("\n"); 
		query.append("		,@[usr_id] CRE_USR_ID " ).append("\n"); 
		query.append("		,sysdate CRE_DT " ).append("\n"); 
		query.append("		,@[usr_id] UPD_USR_ID " ).append("\n"); 
		query.append("		,sysdate UPD_DT" ).append("\n"); 
		query.append("	from bkg_cntr_seal_no seal" ).append("\n"); 
		query.append("	where bkg_no = @[from_bkg]" ).append("\n"); 
		query.append("    and cntr_no =@[cntr_no]" ).append("\n"); 
		query.append("    and cntr_seal_no not in (select seal2.cntr_seal_no " ).append("\n"); 
		query.append(" 							   from bkg_cntr_seal_no seal2" ).append("\n"); 
		query.append("							  where seal2.bkg_no = @[to_bkg]" ).append("\n"); 
		query.append("                                and seal2.cntr_no = @[cntr_no])" ).append("\n"); 

	}
}