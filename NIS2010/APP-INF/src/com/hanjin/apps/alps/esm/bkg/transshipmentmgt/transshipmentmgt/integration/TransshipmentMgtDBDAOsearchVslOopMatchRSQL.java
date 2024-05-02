/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : TransshipmentMgtDBDAOsearchVslOopMatchRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.20
*@LastModifier : 최영희
*@LastVersion : 1.0
* 2009.10.20 최영희
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.transshipmentmgt.transshipmentmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Choi Yeoung Hee
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TransshipmentMgtDBDAOsearchVslOopMatchRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Feeder 선사가 운영하는 선박에 대해 당사 T/S booking 선복 사용에 대해 선박별 이용 선사를 구분 정보와 선사 구분 code를 조회한다.
	  * </pre>
	  */
	public TransshipmentMgtDBDAOsearchVslOopMatchRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_eng_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("crr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.transshipmentmgt.transshipmentmgt.integration").append("\n"); 
		query.append("FileName : TransshipmentMgtDBDAOsearchVslOopMatchRSQL").append("\n"); 
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
		query.append("SELECT VSL.VSL_CD" ).append("\n"); 
		query.append(", VSL.VSL_ENG_NM" ).append("\n"); 
		query.append(", OOP1.OP_CD OOP1" ).append("\n"); 
		query.append(", OOP2.OP_CD OOP2" ).append("\n"); 
		query.append(", OOP3.OP_CD OOP3" ).append("\n"); 
		query.append("FROM MDM_VSL_CNTR VSL, BKG_VSL_OOP OOP1, BKG_VSL_OOP OOP2, BKG_VSL_OOP OOP3" ).append("\n"); 
		query.append("WHERE VSL.VSL_CD = OOP1.VSL_CD(+)" ).append("\n"); 
		query.append("AND OOP1.OP_SEQ(+) = 1" ).append("\n"); 
		query.append("AND VSL.VSL_CD = OOP2.VSL_CD(+)" ).append("\n"); 
		query.append("AND OOP2.OP_SEQ(+) = 2" ).append("\n"); 
		query.append("AND VSL.VSL_CD = OOP3.VSL_CD(+)" ).append("\n"); 
		query.append("AND OOP3.OP_SEQ(+) = 3" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${crr_cd} != '')" ).append("\n"); 
		query.append("AND CRR_CD = @[crr_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${vsl_cd} != '')" ).append("\n"); 
		query.append("AND VSL.VSL_CD = @[vsl_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${vsl_eng_nm} != '')" ).append("\n"); 
		query.append("AND VSL.VSL_ENG_NM like @[vsl_eng_nm]||'%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}