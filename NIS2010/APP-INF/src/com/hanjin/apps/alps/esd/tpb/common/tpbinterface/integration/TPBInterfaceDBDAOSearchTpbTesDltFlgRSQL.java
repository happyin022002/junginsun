/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : TPBInterfaceDBDAOSearchTpbTesDltFlgRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.19
*@LastModifier : 변종건
*@LastVersion : 1.0
* 2010.03.19 변종건
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.tpb.common.tpbinterface.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Jong-Geon Byeon
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TPBInterfaceDBDAOSearchTpbTesDltFlgRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * TES로부터 I/F된 데이터 중에서 Delete 가능 여부 Flag Search
	  * </pre>
	  */
	public TPBInterfaceDBDAOSearchTpbTesDltFlgRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tml_if_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tml_if_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.tpb.common.tpbinterface.integration").append("\n"); 
		query.append("FileName : TPBInterfaceDBDAOSearchTpbTesDltFlgRSQL").append("\n"); 
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
		query.append("SELECT MAX(DECODE(B.DLT_FLG,NULL,'O',B.DLT_FLG)) DLT_FLG" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT @[tml_if_ofc_cd] IF_OFC_CD, @[tml_if_seq] SRC_IF_SEQ_NO" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 
		query.append(") A," ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT IF_OFC_CD" ).append("\n"); 
		query.append(",SRC_IF_SEQ_NO" ).append("\n"); 
		query.append(",CASE WHEN N3PTY_NO IS NOT NULL THEN 'X'" ).append("\n"); 
		query.append("WHEN N3PTY_DELT_TP_CD IN ('D','S') THEN 'Y'" ).append("\n"); 
		query.append("WHEN N3PTY_CFM_CD = 'N' THEN 'Y'" ).append("\n"); 
		query.append("ELSE 'N' END DLT_FLG" ).append("\n"); 
		query.append("FROM TPB_OTS_DTL" ).append("\n"); 
		query.append("WHERE 1 = 1" ).append("\n"); 
		query.append("AND MNL_INP_TP_CD = 'G'" ).append("\n"); 
		query.append("AND N3PTY_EXPN_TP_CD = 'TES'" ).append("\n"); 
		query.append("AND IF_OFC_CD = @[tml_if_ofc_cd]" ).append("\n"); 
		query.append("AND SRC_IF_SEQ_NO = @[tml_if_seq]" ).append("\n"); 
		query.append(") B" ).append("\n"); 
		query.append("WHERE A.IF_OFC_CD = B.IF_OFC_CD(+)" ).append("\n"); 
		query.append("AND A.SRC_IF_SEQ_NO = B.SRC_IF_SEQ_NO(+)" ).append("\n"); 

	}
}