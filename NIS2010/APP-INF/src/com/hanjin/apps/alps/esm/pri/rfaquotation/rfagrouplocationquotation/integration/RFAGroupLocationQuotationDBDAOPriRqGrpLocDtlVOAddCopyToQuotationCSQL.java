/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : RFAGroupLocationQuotationDBDAOPriRqGrpLocDtlVOAddCopyToQuotationCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.19
*@LastModifier : 송민석
*@LastVersion : 1.0
* 2010.03.19 송민석
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.rfaquotation.rfagrouplocationquotation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author SONG MIN SEOK
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class RFAGroupLocationQuotationDBDAOPriRqGrpLocDtlVOAddCopyToQuotationCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * AddCopyToQuotation
	  * </pre>
	  */
	public RFAGroupLocationQuotationDBDAOPriRqGrpLocDtlVOAddCopyToQuotationCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("qttn_ver_no_from",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("qttn_ver_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("qttn_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("qttn_no_from",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.pri.rfaquotation.rfagrouplocationquotation.integration").append("\n"); 
		query.append("FileName : RFAGroupLocationQuotationDBDAOPriRqGrpLocDtlVOAddCopyToQuotationCSQL").append("\n"); 
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
		query.append("INSERT INTO PRI_RQ_GRP_LOC_DTL (" ).append("\n"); 
		query.append("	QTTN_NO" ).append("\n"); 
		query.append(",	QTTN_VER_NO" ).append("\n"); 
		query.append(",	GRP_LOC_SEQ" ).append("\n"); 
		query.append(",	GRP_LOC_DTL_SEQ" ).append("\n"); 
		query.append(",	LOC_CD" ).append("\n"); 
		query.append(",	SRC_INFO_CD" ).append("\n"); 
		query.append(",	CRE_USR_ID" ).append("\n"); 
		query.append(",	CRE_DT" ).append("\n"); 
		query.append(",	UPD_USR_ID" ).append("\n"); 
		query.append(",	UPD_DT" ).append("\n"); 
		query.append(") " ).append("\n"); 
		query.append("SELECT  @[qttn_no]" ).append("\n"); 
		query.append(",	@[qttn_ver_no]" ).append("\n"); 
		query.append(",	GRP_LOC_SEQ" ).append("\n"); 
		query.append(",	GRP_LOC_DTL_SEQ" ).append("\n"); 
		query.append(",	LOC_CD" ).append("\n"); 
		query.append(",	SRC_INFO_CD" ).append("\n"); 
		query.append(",	@[cre_usr_id]" ).append("\n"); 
		query.append(",	SYSDATE" ).append("\n"); 
		query.append(",	@[upd_usr_id]" ).append("\n"); 
		query.append(",	SYSDATE" ).append("\n"); 
		query.append("FROM    PRI_RQ_GRP_LOC_DTL" ).append("\n"); 
		query.append("WHERE   1=1" ).append("\n"); 
		query.append("AND    QTTN_NO = @[qttn_no_from]" ).append("\n"); 
		query.append("AND    QTTN_VER_NO = @[qttn_ver_no_from]" ).append("\n"); 

	}
}