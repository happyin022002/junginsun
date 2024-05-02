/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : Edi315SendDBDAOGetOcRlyPortInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.02.18
*@LastModifier : 이윤정
*@LastVersion : 1.0
* 2010.02.18 이윤정
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.sce.edi315send.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Yoonjung Lee
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class Edi315SendDBDAOGetOcRlyPortInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * GetOcRlyPortInfo
	  * </pre>
	  */
	public Edi315SendDBDAOGetOcRlyPortInfoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("org_yd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dtl_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("edi_sts",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cop_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.sce.edi315send.integration ").append("\n"); 
		query.append("FileName : Edi315SendDBDAOGetOcRlyPortInfoRSQL").append("\n"); 
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
		query.append("SELECT  LOC_CD rly_port," ).append("\n"); 
		query.append("LOC_NM rly_name," ).append("\n"); 
		query.append("CNT_CD rly_code," ).append("\n"); 
		query.append("LOC_AMS_PORT_CD rly_amsport," ).append("\n"); 
		query.append("DECODE(CNT_CD, 'US', 'D', 'K') rly_amsqual" ).append("\n"); 
		query.append("FROM    MDM_LOCATION" ).append("\n"); 
		query.append("WHERE   LOC_CD in (" ).append("\n"); 
		query.append("select" ).append("\n"); 
		query.append("decode(@[edi_sts],    'VAT', substr(@[org_yd_cd], 1, 5)," ).append("\n"); 
		query.append("'UVT', substr(@[org_yd_cd], 1, 5)," ).append("\n"); 
		query.append("'AET', substr(@[org_yd_cd], 1, 5)," ).append("\n"); 
		query.append("'VDT', substr(@[org_yd_cd], 1, 5)," ).append("\n"); 
		query.append("substr(nod_cd, 1, 5))" ).append("\n"); 
		query.append("from sce_cop_dtl" ).append("\n"); 
		query.append("where cop_no = @[cop_no]" ).append("\n"); 
		query.append("and     STND_EDI_STS_CD is not null" ).append("\n"); 
		query.append("and     COP_DTL_SEQ = decode(@[edi_sts] , 'VDL', SUBSTR(TO_CHAR(COP_DTL_SEQ),1,3)||'2'," ).append("\n"); 
		query.append("'VAD', SUBSTR(TO_CHAR(COP_DTL_SEQ),1,3)||'1'," ).append("\n"); 
		query.append("'UVD', SUBSTR(TO_CHAR(COP_DTL_SEQ),1,3)||'1', COP_DTL_SEQ)" ).append("\n"); 
		query.append("and     SUBSTR(TO_CHAR(COP_DTL_SEQ),1,3) in" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("select SUBSTR(TO_CHAR(max(cop_dtl_seq)),1,3)" ).append("\n"); 
		query.append("from  sce_cop_dtl" ).append("\n"); 
		query.append("where cop_no = @[cop_no]" ).append("\n"); 
		query.append("and     (" ).append("\n"); 
		query.append("(@[edi_sts] = 'UVD' and cop_dtl_seq >= '4000' and cop_dtl_seq < '6000' )" ).append("\n"); 
		query.append("or" ).append("\n"); 
		query.append("(@[edi_sts] <> 'UVD'  and cop_dtl_seq = @[dtl_seq])" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("and     STND_EDI_STS_CD is not null" ).append("\n"); 
		query.append("group by cop_no" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("AND rownum = 1" ).append("\n"); 

	}
}