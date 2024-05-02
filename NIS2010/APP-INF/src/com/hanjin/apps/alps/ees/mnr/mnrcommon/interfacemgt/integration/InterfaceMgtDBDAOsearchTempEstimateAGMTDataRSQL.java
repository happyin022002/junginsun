/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : InterfaceMgtDBDAOsearchTempEstimateAGMTDataRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.12.01
*@LastModifier : 박명신
*@LastVersion : 1.0
* 2010.12.01 박명신
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.mnr.mnrcommon.interfacemgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Park Myoung Sin
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class InterfaceMgtDBDAOsearchTempEstimateAGMTDataRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchTempEstimateAGMTData
	  * </pre>
	  */
	public InterfaceMgtDBDAOsearchTempEstimateAGMTDataRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eq_knd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("edi_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.mnr.mnrcommon.interfacemgt.integration").append("\n"); 
		query.append("FileName : InterfaceMgtDBDAOsearchTempEstimateAGMTDataRSQL").append("\n"); 
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
		query.append("SELECT C.AGMT_OFC_CTY_CD,C.AGMT_SEQ,C.AGMT_VER_NO,C.VNDR_SEQ,C.CURR_CD FROM" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("ROW_NUMBER() OVER (ORDER BY A.AGMT_SEQ DESC) ROWNM" ).append("\n"); 
		query.append(",A.AGMT_OFC_CTY_CD" ).append("\n"); 
		query.append(",A.AGMT_SEQ" ).append("\n"); 
		query.append(",A.AGMT_VER_NO" ).append("\n"); 
		query.append(",A.VNDR_SEQ" ).append("\n"); 
		query.append(",A.CURR_CD" ).append("\n"); 
		query.append("FROM MNR_AGMT_HDR A,MNR_PARTNER D" ).append("\n"); 
		query.append("WHERE A.AGMT_LST_VER_FLG = 'Y'" ).append("\n"); 
		query.append("AND D.MNR_GRP_TP_CD = 'RPR'" ).append("\n"); 
		query.append("AND D.MNR_PRNR_SEQ = A.VNDR_SEQ" ).append("\n"); 
		query.append("AND D.CTRL_OFC_CD = A.AGMT_OFC_CD" ).append("\n"); 
		query.append("AND D.EDI_ID = @[edi_id]" ).append("\n"); 
		query.append("AND A.EQ_KND_CD = @[eq_knd_cd]" ).append("\n"); 
		query.append(") C" ).append("\n"); 
		query.append("WHERE ROWNM = 1" ).append("\n"); 

	}
}