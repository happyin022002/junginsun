/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : BLDocumentationBLDBDAOcopyMndByBkgCSQL.java
*@FileTitle :
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.07
*@LastModifier : 최영희
*@LastVersion : 1.0
* 2009.07.07 최영희
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Choi Yeoung Hee
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BLDocumentationBLDBDAOcopyMndByBkgCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();

	Logger log =Logger.getLogger(this.getClass());

	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;

	/**
	  * <pre>
	  * insert
	  * </pre>
	  */
	public BLDocumentationBLDBDAOcopyMndByBkgCSQL(){
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
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("targetBkg",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("insert into bkg_bl_mk_desc(BKG_NO" ).append("\n");
		query.append(",MK_SEQ" ).append("\n");
		query.append(",MK_DESC" ).append("\n");
		query.append(",CMDT_DESC" ).append("\n");
		query.append(",CRE_USR_ID" ).append("\n");
		query.append(",CRE_DT" ).append("\n");
		query.append(",UPD_USR_ID" ).append("\n");
		query.append(",UPD_DT" ).append("\n");
		query.append(")" ).append("\n");
		query.append("select @[targetBkg] BKG_NO" ).append("\n");
		query.append(",(select /*+index_desc ( bkg_bl_mk_desc XPKBKG_BL_MK_DESC)*/" ).append("\n");
		query.append("nvl(sum(MK_SEQ),0)+1" ).append("\n");
		query.append("from bkg_bl_mk_desc" ).append("\n");
		query.append("where MK_SEQ >= 0" ).append("\n");
		query.append("and rownum <= 1" ).append("\n");
		query.append("and bkg_no = @[targetBkg]) MK_SEQ" ).append("\n");
		query.append(",MK_DESC" ).append("\n");
		query.append(",CMDT_DESC" ).append("\n");
		query.append(",@[usr_id] CRE_USR_ID" ).append("\n");
		query.append(",sysdate CRE_DT" ).append("\n");
		query.append(",@[usr_id] UPD_USR_ID" ).append("\n");
		query.append(",sysdate UPD_DT" ).append("\n");
		query.append("from bkg_bl_mk_desc" ).append("\n");
		query.append("where bkg_no = @[bkg_no]" ).append("\n");

		query.append("/*").append("\n");
		query.append("Path : com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.integration ").append("\n");
		query.append("FileName : BLDocumentationBLDBDAOcopyMndByBkgCSQL").append("\n");
		query.append("*/").append("\n");
	}
}