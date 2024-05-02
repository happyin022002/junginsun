/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : CustomerEdiDBDAOSearchEdiStsDescRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.02.08
*@LastModifier : 오현경
*@LastVersion : 1.0
* 2010.02.08 오현경
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.sce.masterdatamanage.customeredidata.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Oh hyun-kyoung
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CustomerEdiDBDAOSearchEdiStsDescRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchEdiStsDesc
	  * </pre>
	  */
	public CustomerEdiDBDAOSearchEdiStsDescRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("edi_grp_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cntr_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("edi_sts",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.sce.masterdatamanage.customeredidata.integration").append("\n"); 
		query.append("FileName : CustomerEdiDBDAOSearchEdiStsDescRSQL").append("\n"); 
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
		query.append("select  'STS:' || CUST_EDI_STS_CD || ' / VSL:' || decode(EDI_VSL_TP_CD, '1', 'TRUNK', '2', 'NOT TRUNK', '3', 'ALL') || ' / EVENT:' ||" ).append("\n"); 
		query.append("decode(EDI_EVNT_CD, '1', 'FIRST', '2', 'NOT FIRST', '3', 'LAST', '4', 'NOT LAST', '5', 'ALL') cust_sts_desc," ).append("\n"); 
		query.append("(select edi_sts_desc from EDI_CGO_STND_STS" ).append("\n"); 
		query.append("where" ).append("\n"); 
		query.append("1=1" ).append("\n"); 
		query.append("#if(${edi_sts} != '')" ).append("\n"); 
		query.append("and edi_stnd_sts_cd = @[edi_sts]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(") edi_sts_desc" ).append("\n"); 
		query.append(", (select RTRIM(XMLAGG(XMLELEMENT(x,nod_cd||',')).EXTRACT('//text()').GetStringVal(),',') AS dtl_nod_cd" ).append("\n"); 
		query.append("from sce_cop_dtl dtl" ).append("\n"); 
		query.append("where  dtl.stnd_edi_sts_cd  = @[edi_sts]" ).append("\n"); 
		query.append("AND cop_no = (select cop_no from sce_cop_hdr where bkg_no = @[bkg_no] and cntr_no = @[cntr_no])) dtl_nod_cd" ).append("\n"); 
		query.append("from   EDI_GRP_CGO" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("#if(${edi_grp_cd} != '')" ).append("\n"); 
		query.append("and edi_grp_cd = @[edi_grp_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${edi_sts} != '')" ).append("\n"); 
		query.append("AND    EDI_STND_STS_CD = @[edi_sts]" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}