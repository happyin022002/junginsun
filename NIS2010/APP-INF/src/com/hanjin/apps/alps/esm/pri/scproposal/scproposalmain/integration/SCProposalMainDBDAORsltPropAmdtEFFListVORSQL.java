/*=========================================================
*Copyright(c) 2017 Hipluscard
*@FileName : SCProposalMainDBDAORsltPropAmdtEFFListVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.09.26
*@LastModifier : 송민석
*@LastVersion : 1.0
* 2017.09.26 송민석
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.scproposal.scproposalmain.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author SONG Min Seok
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SCProposalMainDBDAORsltPropAmdtEFFListVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Amend List 조회
	  * </pre>
	  */
	public SCProposalMainDBDAORsltPropAmdtEFFListVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("prop_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.pri.scproposal.scproposalmain.integration").append("\n"); 
		query.append("FileName : SCProposalMainDBDAORsltPropAmdtEFFListVORSQL").append("\n"); 
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
		query.append("select TO_CHAR(MN.EFF_DT, 'YYYYMMDD') EFF_DT" ).append("\n"); 
		query.append("    ,TO_CHAR(MN.EXP_DT, 'YYYYMMDD')  EXP_DT" ).append("\n"); 
		query.append("    ,TO_CHAR(DUR.CTRT_EFF_DT, 'YYYYMMDD') CTRT_EFF_DT " ).append("\n"); 
		query.append("    , TO_CHAR(DUR.CTRT_EXP_DT, 'YYYYMMDD') CTRT_EXP_DT" ).append("\n"); 
		query.append("     ,( SELECT TO_CHAR(N.EFF_DT ,'YYYYMMDD')" ).append("\n"); 
		query.append("          FROM PRI_SP_MN N" ).append("\n"); 
		query.append("         WHERE N.PROP_NO = MN.PROP_NO AND N.AMDT_SEQ = MN.AMDT_SEQ-1 " ).append("\n"); 
		query.append("       ) PRE_EFF_DT     " ).append("\n"); 
		query.append("	,mn.prop_no,mn.amdt_seq" ).append("\n"); 
		query.append("	,hdr.sc_no" ).append("\n"); 
		query.append("from pri_sp_mn mn, PRI_SP_DUR DUR, pri_sp_hdr hdr" ).append("\n"); 
		query.append("where mn.prop_no = @[prop_no]" ).append("\n"); 
		query.append("    and mn.amdt_seq = @[amdt_seq]" ).append("\n"); 
		query.append("    and mn.prop_no = dur.prop_no " ).append("\n"); 
		query.append("    and mn.amdt_seq = dur.amdt_seq  " ).append("\n"); 
		query.append("	and mn.prop_no = hdr.prop_no" ).append("\n"); 

	}
}