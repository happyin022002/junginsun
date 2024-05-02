/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : TPBInterfaceManageDBDAOSearchGuaranteeTPBIfDataRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.02.04
*@LastModifier : yOng hO lEE
*@LastVersion : 1.0
* 2010.02.04 yOng hO lEE
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.tes.guaranteemanage.tpbinterfacemanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author yOng hO lEE
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TPBInterfaceManageDBDAOSearchGuaranteeTPBIfDataRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * data select
	  * </pre>
	  */
	public TPBInterfaceManageDBDAOSearchGuaranteeTPBIfDataRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("gnte_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.tes.guaranteemanage.tpbinterfacemanage.integration").append("\n"); 
		query.append("FileName : TPBInterfaceManageDBDAOSearchGuaranteeTPBIfDataRSQL").append("\n"); 
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
		query.append("SELECT" ).append("\n"); 
		query.append("GH.GNTE_NO" ).append("\n"); 
		query.append(", GH.TTL_AMT" ).append("\n"); 
		query.append(", GH.OFC_CD" ).append("\n"); 
		query.append(", GH.GNTE_TP_CD" ).append("\n"); 
		query.append(", GH.GNTE_CUST_CD" ).append("\n"); 
		query.append(", (	SELECT CUST_LGL_ENG_NM" ).append("\n"); 
		query.append("FROM MDM_CUSTOMER" ).append("\n"); 
		query.append("WHERE CUST_CNT_CD    = SUBSTR(GH.GNTE_CUST_CD, 0, 2)" ).append("\n"); 
		query.append("AND   CUST_SEQ       = SUBSTR(GH.GNTE_CUST_CD, 3, 6) ) GNTE_CUST_CD_NAME" ).append("\n"); 
		query.append(", GL.TML_GNTE_CNTR_LIST_SEQ" ).append("\n"); 
		query.append(", GL.BKG_NO" ).append("\n"); 
		query.append(", GL.BL_NO" ).append("\n"); 
		query.append(", GL.SC_NO" ).append("\n"); 
		query.append(", GL.CNTR_TPSZ_CD" ).append("\n"); 
		query.append(", GL.CNTR_NO" ).append("\n"); 
		query.append(", GL.VVD_CD" ).append("\n"); 
		query.append(", GL.GNTE_AMT IF_AMT" ).append("\n"); 
		query.append(", GL.TML_IF_OFC_CD" ).append("\n"); 
		query.append(", GL.TML_IF_SEQ" ).append("\n"); 
		query.append(", TP.N3PTY_DESC" ).append("\n"); 
		query.append("FROM    TES_GNTE_HDR GH" ).append("\n"); 
		query.append(", TES_GNTE_CNTR_LIST GL" ).append("\n"); 
		query.append(", TES_N3RD_PTY_IF TP" ).append("\n"); 
		query.append("WHERE   1   = 1" ).append("\n"); 
		query.append("AND     GH.GNTE_NO  = GL.GNTE_NO" ).append("\n"); 
		query.append("AND     GH.GNTE_NO  = @[gnte_no]" ).append("\n"); 
		query.append("AND		GL.TML_IF_OFC_CD	= TP.TML_IF_OFC_CD(+)" ).append("\n"); 
		query.append("AND		GL.TML_IF_SEQ		= TP.TML_IF_SEQ(+)" ).append("\n"); 
		query.append("#if (${tml_gnte_cntr_list_seq} != '')" ).append("\n"); 
		query.append("AND     GL.TML_GNTE_CNTR_LIST_SEQ IN (" ).append("\n"); 
		query.append("#foreach($tml_gnte_cntr_list_seq_num IN ${tml_gnte_cntr_list_seq})" ).append("\n"); 
		query.append("#if($velocityCount < $tml_gnte_cntr_list_seq.size())" ).append("\n"); 
		query.append("'$tml_gnte_cntr_list_seq_num'," ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("'$tml_gnte_cntr_list_seq_num'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}